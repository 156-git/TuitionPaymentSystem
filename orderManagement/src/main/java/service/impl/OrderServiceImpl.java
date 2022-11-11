package service.impl;

import Mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import pojo.PageBean;
import service.OrderService;
import util.SqlSessionFactoryUtils;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    static SqlSession sqlSession = factory.openSession(true);
    static OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

    static PageBean<Order> pageBean = new PageBean<Order>();


    //查询业务
    public PageBean<Order> query(String keyword, int currentPage, int pageSize) {

        int total;
        float totalMoney;
        List<Order> orders;

        //无关键词
        if ( keyword==null||keyword.equals("")) {
            //设置总金额
            totalMoney=orderMapper.selectTotalAmount();
            //一系列订单对象
            orders= orderMapper.selectByPage(currentPage - 1, pageSize);
            //记录总条数
            total = orderMapper.selectTotalCount();


        } else {

            keyword = "%" + keyword + "%";
            boolean flag = keyword.matches("%([0-9a-zA-Z])+%");
            if (flag) {//订单号关键词
                totalMoney=orderMapper.selectTotalAmountByOrder_numKeyword(keyword);
                orders = orderMapper.selectByOrder_num(keyword, currentPage - 1, pageSize);
                total = orderMapper.selectTotalByOrder_numKey();

            } else {//班级关键词

                totalMoney=orderMapper.selectTotalAmountByStu_classKeyword(keyword);
                orders = orderMapper.selectByStu_class(keyword, currentPage - 1, pageSize);
                total = orderMapper.selectTotalByStu_classKey();
            }

        }
        //填入pageBean对象
        pageBean.setTotalAmount(totalMoney);
        pageBean.setTotalCount(total);
        pageBean.setRows(orders);

        return pageBean;
    }


    //查询总金额
    public float queryTotalAmount(String keyword) {
        float sum;
        if (keyword == null || keyword.equals("")) {
            sum = orderMapper.selectTotalAmount();
        } else {
            keyword = "%" + keyword + "%";
            boolean flag;
            flag = keyword.matches("%([0-9a-zA-Z])+%");
            if (flag) {
                sum = orderMapper.selectTotalAmountByOrder_numKeyword(keyword);
            } else {
                sum = orderMapper.selectTotalAmountByStu_classKeyword(keyword);
            }
        }

        return sum;
    }


    //添加订单
    public int addOrder(Order order) {
        return orderMapper.insertOrder(order);
    }


    //根据订单号删除订单
    public PageBean<Order> deleteOrder(String keyword, String order_num, int currentPage, int pageSize) {


        return pageBean;
    }


    //根据一系列订单号删除订单
    public int deleteOrders(String[] order_nums) {
        return orderMapper.deleteByOrder_nums(order_nums);
    }

    //修改整条订单
    public PageBean<Order> modifyOrder(String keyword, Order order, int currentPage, int pageSize){
        int change=orderMapper.updateOrder(order);
        return query(keyword,currentPage,pageSize);
    }


    //释放资源
    public void releaseSqlSession() {
        sqlSession.close();
    }



}
