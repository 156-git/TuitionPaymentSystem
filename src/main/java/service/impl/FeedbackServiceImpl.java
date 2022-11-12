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



    //
    @Override
    public int modifyFeedback(String order_num, String fdbcon) {

        return 0;
    }


    //
    @Override
    public int delete(String order_num) {
        return 0;
    }
}
