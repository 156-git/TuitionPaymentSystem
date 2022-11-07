package service;

import Mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import pojo.PageBean;
import util.SqlSessionFactoryUtils;

import java.util.List;

public interface OrderService {
        //分页查询
        PageBean<Order> queryByPage(int currentPage, int pageSize);


        //查询总金额
        float queryTotalAmount();


        //添加订单
        int addOrder(Order order);


        //根据订单号删除订单
        int deleteOrder(String order_num);


        //根据一系列订单号删除订单
        int deleteOrders(String [] order_nums);



        //释放资源
        void releasesqlSession();

    }

