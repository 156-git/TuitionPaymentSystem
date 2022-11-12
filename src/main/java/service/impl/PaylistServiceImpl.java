package service.impl;

import Mapper.PaylistMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Paylist;
import service.PaylistService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class PaylistServiceImpl implements PaylistService {

    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    static SqlSession sqlSession = factory.openSession(true);
    static PaylistMapper paylistMapper = sqlSession.getMapper(PaylistMapper.class);

    //查询业务
    @Override
    public List<Paylist> query(String keyword, int currentPage, int pageSize) {

        List<Paylist> payLists;

        //无关键词
        if (keyword == null || keyword.equals("")) {
            payLists = paylistMapper.selectAll(currentPage - 1, pageSize);
        } else {
            keyword = "%" + keyword + "%";
            boolean flag = keyword.matches("%([0-9a-zA-Z])%");
            if (flag) {
                //学号关键词
                payLists = paylistMapper.selectByStu_num(keyword, currentPage - 1, pageSize);
            } else {
                //姓名关键词
                payLists = paylistMapper.selectByStu_name(keyword, currentPage - 1, pageSize);
            }
        }
        return payLists;
    }

    //添加业务,添加新的缴费订单
    @Override
    public int add(Paylist paylist) {
        return paylistMapper.addPayList(paylist);
    }

    //删除业务，只可以删除未支付订单
    @Override
    public int delete(String[] stu_nums) {
        return paylistMapper.updateStateByStu_nums(stu_nums);
    }

    //修改业务，可修改总金额
    @Override
    public int modify(String stu_num, float payment) {
        return paylistMapper.updateMoney(stu_num,payment);
    }

}
