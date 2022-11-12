package service.impl;

import pojo.AbnormalOrder;
import pojo.Feedback;
import service.AbnormalOrderService;
import java.util.List;

public class AbnormalOrderServiceImpl implements AbnormalOrderService {
    @Override
    public List<AbnormalOrder> query(String keyword, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public int createFeedback(Feedback feedback) {
        return 0;
    }

    @Override
    public int delete(String order_num) {
        return 0;
    }





}
