package service.impl;

import Mapper.OrderManageMapper;
import Mapper.PaylistMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.AbnormalOrder;
import pojo.Order;
import pojo.Paylist;
import service.PaylistService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class PaylistServiceImpl implements PaylistService {

    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    static SqlSession sqlSession = factory.openSession(true);
    static PaylistMapper paylistMapper = sqlSession.getMapper(PaylistMapper.class);

    //添加缴费名单之后调用，添加其他表的数据
    @Override
    public int addOther(Paylist paylist, String order_num) {
        int i;
        if (paylist.getState() == 1 && paylist.getShow_state() == 1) {
            Order order = new Order();
            order.setOrder_num(order_num);
            order.setStu_num(paylist.getStu_num());
            order.setStu_name(paylist.getStu_name());
            order.setStu_class(paylist.getStu_class());
            order.setStu_money(paylist.getPayment());
            order.setOrder_time(paylist.getTime());
            i = paylistMapper.addOrderByState(order);
        } else {
            AbnormalOrder ao = new AbnormalOrder();
            ao.setOrder_num(order_num);
            ao.setStu_num(paylist.getStu_num());
            ao.setStu_name(paylist.getStu_name());
            ao.setStu_class(paylist.getStu_class());
            ao.setStu_money(paylist.getPayment());
            ao.setOrder_time(paylist.getTime());
            i = paylistMapper.addAbnormalOrderByState(ao);
        }
        return i;
    }

    //查询业务
    @Override
    public List<Paylist> query(String keyword, int currentPage, int pageSize) {

        List<Paylist> payLists;

        //无关键词
        if (keyword == null || keyword.equals("")) {
            payLists = paylistMapper.selectAll(currentPage - 1, pageSize);
        } else {
            keyword = "%" + keyword + "%";
            boolean flag = keyword.matches("%([0-9a-zA-Z])+%");
            if (flag) {
                //学号关键词
                payLists = paylistMapper.selectByStu_num(keyword, currentPage - 1, pageSize);
            } else {
                //姓名关键词
                payLists = paylistMapper.selectByStu_name(keyword, currentPage - 1, pageSize);
            }
        }
        return payLists;
    }

    //添加业务,添加新的缴费订单
    @Override
    public int add(Paylist paylist) {
        return paylistMapper.addPayList(paylist);
    }

    //删除业务，只可以删除未支付订单
    @Override
    public int delete(String[] stu_nums) {
        return paylistMapper.updateShow_stateByStu_nums(stu_nums);
    }

    //修改业务，可修改总金额
    @Override
    public int modify(String stu_num, float payment) {
        return paylistMapper.updateMoney(stu_num, payment);
    }

}
