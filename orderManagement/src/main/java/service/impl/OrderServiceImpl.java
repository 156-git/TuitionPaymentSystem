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



    //分页查询
/*
    currentPage当前页码
    pageSize每页显示条数
 */
    public PageBean<Order> queryByPage(int currentPage, int pageSize){

         List<Order> rows=orderMapper.selectByPage(currentPage-1,pageSize);

         int totalCount=orderMapper.selectTotalCount();

         PageBean<Order> pageBean=new PageBean<Order>();

         pageBean.setRows(rows);
         pageBean.setTotalcount(totalCount);

         return pageBean;
    }


    //关键词查询
    public List<Order> queryOrdersBykeyword(String keyword){
        keyword="%"+keyword+"%";
        boolean flag;
        List<Order> orders;
        flag=keyword.matches("%([0-9a-zA-Z])+%");
        if(flag){
            orders=orderMapper.selectByOrder_num(keyword);
        }else {
            orders=orderMapper.selectByStu_class(keyword);
        }

        return orders;
    }



    //查询总金额
    public float queryTotalAmount() {
        return orderMapper.selectTotalAmount();
    }


    //添加订单
    public int addOrder(Order order){
        return orderMapper.insertOrder(order);
    }


    //根据订单号删除订单
    public  int deleteOrder(String order_num){
      return  orderMapper.deleteByOrder_num(order_num);
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
