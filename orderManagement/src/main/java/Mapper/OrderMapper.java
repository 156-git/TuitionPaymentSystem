package Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Order;
import java.util.List;

public interface OrderMapper {

    //返回总金额
    @Select("select SUM(stu_money) from orders where order_state=1")
    float selectTotalAmount();

    //根据模糊订单号关键词返回总金额
    @Select("select SUM(stu_money) from orders where order_num like #{keyword} and order_state=1")
    float selectTotalAmountByOrder_numKeyword(String keyword);

    //根据模糊班级返回总金额
    @Select("select SUM(stu_money) from orders where stu_class like #{keyword} and order_state=1")
    float selectTotalAmountByStu_classKeyword(String keyword);


    //查询总数据条数
    @Select("select  count(*)  from orders")
    int selectTotalCount();

    //分页查询
    @Select("select * from orders  where order_state=1 limit #{begin} , #{size}")
    List<Order> selectByPage(@Param("begin") int begin, @Param("size") int size);


    //批量修改订单状态
    int updateStateByOrder_nums(@Param("nums") String[] order_nums);


    //删除订单  通过订单号删除
    @Delete("delete from orders where order_num=#{order_num}")
    int deleteByOrder_num(String order_num);

    //删除订单  批量删除
    int deleteByOrder_nums(@Param("nums") String[] order_nums);


    //添加订单
    int insertOrder(Order order);


    //通过订单号关键词模糊查询
    @Select("select * from orders where order_num like #{keyword} and order_state=1  limit  #{begin} , #{size} ")
    List<Order> selectByOrder_num(@Param("keyword")String keyword,@Param("begin") int begin, @Param("size") int size);

    //通过班级关键词模糊查询
    @Select("select * from orders where stu_class like #{keyword} and order_state=1  limit  #{begin} , #{size} ")
    List<Order> selectByStu_class(@Param("keyword")String keyword,@Param("begin") int begin, @Param("size") int size);

    //通过订单号模糊关键词统计订单条数
    @Select("select count(*) from orders where order_num like #{keyword} and order_state=1")
    int selectTotalByOrder_numKey();

    //通过班级模糊关键词统计订单条数
    @Select("select count(*) from orders where stu_class like #{keyword} and order_state=1")
    int selectTotalByStu_classKey();

    //修改订单
    @Update("update orders set stu_money=#{stu_money},order_state=#{order_state},stu_class=#{stu_class},stu_name=#{stu_name},stu_num=#{stu_num},order_time=#{order_time},order_num=#{order_num}  where order_num=#{order_num}")
    int updateOrder(Order order);

}
