package service.impl;

import Mapper.AbnormalOrderMapper;
import Mapper.FeedbackMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Feedback;
import service.FeedbackService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    SqlSession sqlSession = factory.openSession(true);

    FeedbackMapper fdbkMap=sqlSession.getMapper(FeedbackMapper.class);
    boolean flag;

    List<Feedback> feedbacks;


    //综合分页查询反馈订单
    @Override
    public List<Feedback> query(String keyword, int currentPage, int pageSize) {
        flag=keyword.matches("([0-9a-zA-Z])+");

        if (flag||(keyword==null)){//无关键词或订单号关键词
            keyword="%"+keyword+"%";
            return feedbacks=fdbkMap.selectFdOds(keyword,currentPage,pageSize);
        }else {//姓名关键词
            keyword="%"+keyword+"%";
            return feedbacks=fdbkMap.selectFdOdsByName(keyword);
        }

    }



    //添加反馈内容
    @Override
    public int addFdback(String order_num, String fdbcon) {
        return fdbkMap.updatefdbkCon(order_num,fdbcon);

    }


    //逻辑删除已处理订单
    @Override
    public int delete(String [] order_nums) {
       return fdbkMap.deleteFdbksByOrder_num(order_nums);

    }


    //修改反馈记录状态
    @Override
    public int modifyFdbkState(String order_num) {
        return fdbkMap.updateState(order_num);
    }

}
