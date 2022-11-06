package Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Order;

public interface OrderMapper {
    //查询并返回总金额
    @Select("select SUM(stu_money) from orders")
    float selectTotalAmount();

    //根据订单号查询订单

    //根据班级查询订单

    //分页查询


    //删除订单  通过订单号删除
    @Delete("delete from orders where order_num=#{order_num}")
    int deleteByOrder_num(String order_num);

    //删除订单  批量删除
    int deleteByOrder_nums(@Param("nums") String[] order_nums);

    //添加订单
    int insertOrder(Order order);

}
