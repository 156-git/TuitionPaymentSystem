package service;

import pojo.Order;
import pojo.PageBean;

public interface OrderService {


        //查询总金额
        float queryTotalAmount(String keyword);


        //添加订单
        int addOrder(Order order);


        //根据订单号删除订单
        PageBean<Order> deleteOrder(String keyword ,String order_num,int currentPage,int pageSize );


        //根据一系列订单号删除订单
        int deleteOrders(String [] order_nums);


        //释放资源
        void releasesqlSession();

        //关键词查询
        PageBean<Order> queryOrdersByKeyword(String keyword,int currentPage,int pageSize);

    }

