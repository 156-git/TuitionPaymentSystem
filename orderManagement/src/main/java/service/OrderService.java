package service;

import Mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import util.SqlSessionFactoryUtils;

public class OrderService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    static SqlSession sqlSession = factory.openSession(true);
    static OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);







    //查询总金额
    public float queryTotalAmount() {
        return orderMapper.selectTotalAmount();
    }


    //添加订单
    public int addOrder(Order order){
        return orderMapper.insertOrder(order);
    }


    //根据订单号删除订单
    public  int deleteOrder(String order_num){
      return  orderMapper.deleteByOrder_num(order_num);
    }


    //根据一系列订单号删除订单
    public int deleteOrders(String [] order_nums){
        return orderMapper.deleteByOrder_nums(order_nums);
    }



    //释放资源
    public void releasesqlSession(){
        sqlSession.close();
    }

}
