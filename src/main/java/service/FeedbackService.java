package service;

import pojo.Feedback;
import java.util.List;

public interface FeedbackService {

    //根据反馈记录关键词分页查询,未处理订单在前，时间降序
    List<Feedback> query(String keyword,int currentPage,int pageSize);



    //处理订单反馈，添加反馈内容
    int modifyFeedback(String order_num,String content);

    //只可以逻辑删除已处理的记录
     int delete(String order_num);





}
