package Mapper;

import org.apache.ibatis.annotations.Param;
import pojo.AbnormalOrder;
import pojo.Feedback;
import java.util.List;

public interface AbnormalOrderMapper {

    //根据订单号或者无条件分页查询异常订单
    List<AbnormalOrder> selectAnOds(@Param("keyword") String keyword,@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    //根据名字关键字查询异常订单
    List<AbnormalOrder> selectAnOdsByName(@Param("keyword") String keyword,@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);


    //提交反馈后即生成反馈订单
    int insertFdbkOrder(Feedback feedback);


    //通过修改状态值达到逻辑删除
    int deleteModifyShow_State(@Param("order_nums") String [] order_nums);


    //修改异常订单的处理状态
    int updateOrderState(String order_num);

}
