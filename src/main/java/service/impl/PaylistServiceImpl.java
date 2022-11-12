package service.impl;

import pojo.Paylist;
import service.PaylistService;

import java.util.List;

public class PaylistServiceImpl implements PaylistService {
    //查询业务
    @Override
    public List<Paylist> query(String keyword, int currentPage, int pageSize) {
        return null;
    }

    //添加业务,添加新的缴费订单
    @Override
    public List<Paylist> add(Paylist paylist) {
        return null;
    }

    //删除业务，只可以删除未支付订单
    @Override
    public List<Paylist> delete(String[] stu_nums) {
        return null;
    }

    //修改业务，可修改总金额
    @Override
    public List<Paylist> modify(float money) {
        return null;
    }

}
