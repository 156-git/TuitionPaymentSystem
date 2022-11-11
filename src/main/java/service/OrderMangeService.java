package service;

import pojo.Order;
import pojo.pageBean.OrderManagePageBean;

public interface OrderMangeService {

        //关键词查询
        OrderManagePageBean<Order> query(String keyword, int currentPage, int pageSize);


        //查询总金额
        float queryTotalAmount(String keyword);


        //通过修改订单状态来删除订单
        OrderManagePageBean<Order> deleteOrders(String keyword , String[] order_nums, int currentPage, int pageSize );


        //添加订单
        int addOrder(Order order);


        //释放资源
        void releaseSqlSession();

    }

