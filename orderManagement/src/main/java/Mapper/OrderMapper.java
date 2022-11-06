package Mapper;

import org.apache.ibatis.annotations.Select;
import pojo.Order;

public interface OrderMapper {
    //查询并返回总金额
    @Select("select SUM(stu_money) from orders")
    float selectTotalAmount();

    //根据订单号查询订单

    //根据班级查询订单

    //分页查询

    //删除订单  通过order_seq删除
    void deleteByOrder_seq(int order_seq);

    //删除订单  批量删除
    void deleteByOrder_seqs(int[] order_seqs);

    //添加订单
    void addOrder(Order order);

}
