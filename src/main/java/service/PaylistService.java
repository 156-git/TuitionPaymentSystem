package service;

import pojo.Paylist;

import java.util.List;

public interface PaylistService {

    //分页显示缴费名单
    List<Paylist> query(String keyword, int currentPage, int pageSize);

    //添加业务
    int add(Paylist paylist);

    //删除业务
    int delete(String[] stu_nums);

    //修改业务，可以对缴费金额做修改
    int modify(String stu_num, float payment);


}
