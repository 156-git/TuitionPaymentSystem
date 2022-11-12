package service;

import pojo.Paylist;

import java.util.List;

public interface PaylistService {

    //分页显示缴费名单
     List<Paylist> query(String keyword,int currentPage,int pageSize);

    //添加业务
    List<Paylist> add(Paylist paylist);

    //删除业务
    List<Paylist> delete(String [] stu_nums);

    //修改业务，可以对缴费金额做修改
    List<Paylist> modify(float money);


}
