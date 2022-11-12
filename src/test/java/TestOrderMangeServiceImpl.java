import org.junit.Test;
import pojo.Order;
import pojo.pageBean.OrderManagePageBean;
import service.OrderMangeService;
import service.impl.OrderMangeServiceImpl;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestOrderMangeServiceImpl {
    OrderMangeService orderMangeService = new OrderMangeServiceImpl();


    //测试查询总金额业务
    @Test
    public void testTotalAmount() {
        System.out.println("你好");
    }



    //测试添加订单业务
    @Test
    public void testAddOrder() {
        //接受参数
        String order_num = "KB09010105";
        String stu_num = "20210210260209";
        String stu_name = "王五";
        String stu_class = "软工7班";
        float stu_money = 2222;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stu_time = sdf.format(date);
        int order_state = 1;
        //        2.封装对象
        Order order = new Order();
        order.setOrder_num(order_num);
        order.setStu_num(stu_num);
        order.setStu_name(stu_name);
        order.setStu_class(stu_class);
        order.setStu_money(stu_money);
        order.setOrder_time(stu_time);
        order.setOrder_state(order_state);

        //调用添加订单业务


    }




    //根据order_num删除
    @Test
    public void testDeleteByOrder_num()  {
        //接受参数
        String order_num="KB09010103";
        System.out.println("删除"+"个数据");
    }






    @Test
    //测试根据关键字模糊查询业务
    public void testQueryOrdersByKeyWord(){
        List<Order> orders;
        OrderManagePageBean<Order> orderManagePageBean =new OrderManagePageBean<Order>();
        orderManagePageBean = orderMangeService.query("KB09010105",1, 2);
    }


}
