package service;


import pojo.AbnormalOrder;
import pojo.Feedback;

import java.util.List;

public interface AbnormalOrderService {
    //显示支付失败订单,且分页查询，按订单时间降序
    List<AbnormalOrder> query(String keyword,int currentPage,int pageSize);

    //填写反馈意见并生成反馈订单
    int createFeedback(Feedback feedback);


    //逻辑删除指定订单
    List<AbnormalOrder> delete(String order_num,String keyword, int currentPage, int pageSize);

}
