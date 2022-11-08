package service.impl;

import Mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import pojo.PageBean;
import service.OrderService;
import util.SqlSessionFactoryUtils;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    static SqlSession sqlSession = factory.openSession(true);
    static OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

    static PageBean<Order> pageBean=new PageBean<Order>();


    //查询业务
    public PageBean<Order> queryOrdersByKeyword(String keyword,int currentPage,int pageSize){

        int total;
        boolean flag;
        List<Order> orders;

        if(keyword==null||keyword.equals("")){
            List<Order> rows=orderMapper.selectByPage(currentPage-1,pageSize);
            int totalCount=orderMapper.selectTotalCount();
            pageBean.setRows(rows);
            pageBean.setTotalcount(totalCount);
        }else {
            keyword="%"+keyword+"%";
            flag=keyword.matches("%([0-9a-zA-Z])+%");
            if (flag) {
                orders = orderMapper.selectByOrder_num(keyword, currentPage - 1, pageSize);
                total = orderMapper.selectTotalByOreder_numKey();
                pageBean.setTotalcount(total);
                pageBean.setRows(orders);

            } else {
                orders = orderMapper.selectByStu_class(keyword, currentPage - 1, pageSize);
                total = orderMapper.selectTotalByStu_classKey();
                pageBean.setTotalcount(total);
                pageBean.setRows(orders);
            }
        }
        return pageBean;
    }



    //查询总金额
    public float queryTotalAmount(String keyword) {
        float sum;
        if(keyword==null||keyword.equals("")){
            sum=orderMapper.selectTotalAmount();
        }else {
            keyword="%"+keyword+"%";
            boolean flag;
            flag=keyword.matches("%([0-9a-zA-Z])+%");
            if (flag){
                sum=orderMapper.selectTotalAmountByOrder_numKeyword(keyword);
            }else {
                sum=orderMapper.selectTotalAmountByStu_classKeyword(keyword);
            }
        }

        return sum;
    }


    //添加订单
    public int addOrder(Order order){
        return orderMapper.insertOrder(order);
    }


    //根据订单号删除订单
    public PageBean<Order> deleteOrder(String keyword,String order_num,int currentPage,int pageSize ){
        orderMapper.deleteByOrder_num(order_num);
       if((keyword==null)||keyword.equals("")){

       }


       return pageBean;
    }


    //根据一系列订单号删除订单
    public int deleteOrders(String [] order_nums){
        return orderMapper.deleteByOrder_nums(order_nums);
    }



    //释放资源
    public void releasesqlSession(){
        sqlSession.close();
    }

}
