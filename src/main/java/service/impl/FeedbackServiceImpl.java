package service.impl;

import pojo.Feedback;
import service.FeedbackService;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public List<Feedback> query(String keyword, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public int modifyFeedback(String order_num, String content) {
        return 0;
    }

    @Override
    public int delete(String order_num) {
        return 0;
    }
}
