package service.impl;

import Mapper.OrderManageMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import pojo.pageBean.OrderManagePageBean;
import service.OrderMangeService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class OrderMangeServiceImpl implements OrderMangeService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    SqlSession sqlSession = factory.openSession(true);
    OrderManageMapper orderMapper = sqlSession.getMapper(OrderManageMapper.class);

    OrderManagePageBean<Order> orderManagePageBean = new OrderManagePageBean<Order>();


    //查询业务
    public OrderManagePageBean<Order> query(String keyword, int currentPage, int pageSize) {

        int total;
        float totalMoney;
        List<Order> orders;

        //无关键词
        if (keyword == null || keyword.equals("")) {
            //设置总金额
            totalMoney = orderMapper.selectTotalAmount();
            //一系列订单对象
            orders = orderMapper.selectByPage(currentPage - 1, pageSize);
            //记录总条数
            total = orderMapper.selectTotalCount();
        } else {
            keyword = "%"+keyword + "%";
            boolean flag = keyword.matches("%([0-9a-zA-Z])%");
            if (flag) {
                //订单号关键词
                totalMoney = orderMapper.selectTotalAmountByOrder_numKeyword(keyword);
                orders = orderMapper.selectByOrder_num(keyword, currentPage - 1, pageSize);
                total = orderMapper.selectTotalByOrder_numKey();
            } else {
                //班级关键词
                totalMoney = orderMapper.selectTotalAmountByStu_classKeyword(keyword);
                orders = orderMapper.selectByStu_class(keyword, currentPage - 1, pageSize);
                total = orderMapper.selectTotalByStu_classKey();
            }
        }
        //填入pageBean对象
        orderManagePageBean.setTotalAmount(totalMoney);
        orderManagePageBean.setTotalCount(total);
        orderManagePageBean.setRows(orders);

        return orderManagePageBean;
    }



    //查询总金额
    public float queryTotalAmount(String keyword) {
        float sum;
        if (keyword == null || keyword.equals("")) {
            sum = orderMapper.selectTotalAmount();
        } else {
            keyword = "%"+keyword + "%";
            boolean flag = keyword.matches("%([0-9a-zA-Z])+%");
            if (flag) {
                sum = orderMapper.selectTotalAmountByOrder_numKeyword(keyword);
            } else {
                sum = orderMapper.selectTotalAmountByStu_classKeyword(keyword);
            }
        }
        return sum;
    }



    //通过修改订单状态来删除订单
    public OrderManagePageBean<Order> deleteOrders(String keyword, String[] order_nums, int currentPage, int pageSize) {
        int i = orderMapper.updateStateByOrder_nums(order_nums);
        return query(keyword, currentPage - 1, pageSize);
    }



    //释放资源
    public void releaseSqlSession() {
        sqlSession.close();
    }

}
