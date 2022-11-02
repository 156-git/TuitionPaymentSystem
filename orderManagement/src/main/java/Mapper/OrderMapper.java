package Mapper;

import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    //查询并返回总金额
    @Select("select SUM(stu_money) from orders")
    float selectToalAmount();

    //根据订单号查询订单

    //根据班级查询订单

    //分页查询

    //删除订单

    //添加订单



}
