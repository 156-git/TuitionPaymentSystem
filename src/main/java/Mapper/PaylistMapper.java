package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.AbnormalOrder;
import pojo.Order;
import pojo.Paylist;

import java.util.List;

public interface PaylistMapper {

    //通过state=1来添加订单信息
   int addOrderByState(Order order);

   //通过state=0来添加异常记录
    int addAbnormalOrderByState(AbnormalOrder ao);

    //通过姓名模糊查询缴费订单
    List<Paylist> selectByStu_name(@Param("stu_name") String stu_name,@Param("begin") int begin, @Param("size") int size);

    //通过学号模糊查询缴费名单
    List<Paylist> selectByStu_num(@Param("stu_num") String stu_num,@Param("begin") int begin, @Param("size") int size);

    //查询所有缴费名单
    @Select("select * from paylist where show_state=1  limit  #{begin} , #{size} ")
    List<Paylist> selectAll(@Param("begin") int begin, @Param("size") int size);


    //修改缴费金额
    @Update("update paylist set payment=#{payment} where stu_num=#{stu_num} and show_state=1")
    int updateMoney(@Param("stu_num") String stu_num,@Param("payment") float payment);


    //修改订单状态，逻辑删除缴费名单
    int updateShow_stateByStu_nums(String[] stu_nums);

    //添加缴费名单
    int addPayList(Paylist paylist);
}
