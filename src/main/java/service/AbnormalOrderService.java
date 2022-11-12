package service;


import pojo.AbnormalOrder;
import pojo.Feedback;

import java.util.List;

public interface AbnormalOrderService {
    //显示支付失败订单,且分页查询，按订单时间降序
    List<AbnormalOrder> query(String keyword,int currentPage,int pageSize);

    //填写反馈意见并生成反馈订单,并修改异常订单处理状态
    int createFeedback(Feedback feedback,String order_num);


    //逻辑删除指定订单
    int delete(String order_num);

}
