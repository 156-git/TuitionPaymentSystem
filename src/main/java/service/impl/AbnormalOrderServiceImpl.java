package service.impl;

import Mapper.AbnormalOrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.AbnormalOrder;
import pojo.Feedback;
import service.AbnormalOrderService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class AbnormalOrderServiceImpl implements AbnormalOrderService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    SqlSession sqlSession = factory.openSession(true);

    AbnormalOrderMapper anOdMap=sqlSession.getMapper(AbnormalOrderMapper.class);

    Boolean flag;
    List<AbnormalOrder> abnormalOrders;



    //综合分页查询异常订单
    @Override
    public List<AbnormalOrder> query(String keyword, int currentPage, int pageSize) {
        flag=keyword.matches("([0-9a-zA-Z])+");

        if (flag||(keyword==null)){//无关键词或订单号关键词
            keyword="%"+keyword+"%";
            return abnormalOrders=anOdMap.selectAnOds(keyword,currentPage,pageSize);
        }else {//姓名关键词
            keyword="%"+keyword+"%";
            return abnormalOrders=anOdMap.selectAnOdsByName(keyword);
        }

    }



    //提交反馈后即生成反馈订单
    @Override
    public int createFeedback(Feedback feedback) {
        return anOdMap.insertFdbkOrder(feedback);

    }



    //改变状态值逻辑删除
    @Override
    public List<AbnormalOrder> delete(String order_num,String keyword, int currentPage, int pageSize) {
        int i=anOdMap.deleteModifyState(order_num);
        return query(keyword,currentPage,pageSize);
    }



}