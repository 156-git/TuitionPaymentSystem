package service;

import pojo.Order;
import pojo.PageBean;

public interface OrderService {

        //关键词查询
        PageBean<Order> query(String keyword,int currentPage,int pageSize);


        //查询总金额
        float queryTotalAmount(String keyword);


        //通过修改订单状态来删除订单
        PageBean<Order> deleteOrders(String[] order_nums,String keyword ,int currentPage,int pageSize );


        //添加订单
        PageBean<Order> addOrder(Order order,String keyword, int currentPage, int pageSize);


        //释放资源
        void releaseSqlSession();

    }

