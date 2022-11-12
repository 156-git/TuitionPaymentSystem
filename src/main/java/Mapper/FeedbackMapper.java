package Mapper;

import pojo.AbnormalOrder;
import pojo.Feedback;

import java.util.List;

public interface FeedbackMapper{

    //根据订单号或者无条件分页查询反馈订单
    List<Feedback> selectFdOds(String keyword, int currentPage, int pageSize);

    //根据名字关键字查询异常订单
    List<Feedback> selectFdOdsByName(String stu_name);
}
