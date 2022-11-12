package Mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Feedback;

import java.util.List;

public interface FeedbackMapper{

    //根据订单号或者无条件分页查询反馈订单
    List<Feedback> selectFdOds(@Param("keyword") String keyword, @Param("currentPage") int currentPage,@Param("pageSize") int pageSize);

    //根据名字关键字查询异常订单
    List<Feedback> selectFdOdsByName(String stu_name);

    //修改反馈记录的状态
    int updateState(String order_num);


    //删除已受理反馈,改变显示状态,逻辑删除
    int deleteFdbksByOrder_num(@Param("nums") String [] nums);


    //添加反馈内容
    int updatefdbkCon(@Param("order_num") String order_num,@Param("newCon") String newCon);

}





