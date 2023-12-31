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
        if(keyword.equals("")||keyword==null){//无关键词
            return abnormalOrders=anOdMap.selectAnOds(keyword,currentPage-1,pageSize);
        }else if (flag){//订单号关键词
            keyword="%"+keyword+"%";
            return abnormalOrders=anOdMap.selectAnOds(keyword,currentPage-1,pageSize);
        }else {//姓名关键词
            keyword="%"+keyword+"%";
            return abnormalOrders=anOdMap.selectAnOdsByName(keyword,currentPage-1,pageSize);
        }

    }



    //提交反馈后即生成反馈订单,并修改订单为已处理
    @Override
    public int createFeedback(Feedback feedback) {
        anOdMap.updateOrderState(feedback.getOrder_num());
        return anOdMap.insertFdbkOrder(feedback);

    }



    //改变状态值,逻辑删除
    @Override
    public int delete(String [] order_nums) {
        return anOdMap.deleteModifyShow_State(order_nums);
    }



}