import org.junit.Test;
import pojo.Order;
import service.OrderService;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TestOrderService {
    OrderService orderService = new OrderService();




    //测试查询总金额业务
    @Test
    public void testTotalAmount() {
        float f = orderService.queryTotalAmount();
        System.out.println(f);
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
         int i=orderService.addOrder(order);
        System.out.println("添加"+i+"条数据成功");

    }




    //根据order_num删除
    @Test
    public void testDeleteByOrder_num()  {
        //接受参数
        String order_num="KB09010103";
        int i=orderService.deleteOrder(order_num);
        System.out.println("删除"+i+"个数据");
    }




    //根据数组order_nums批量删除
    @Test
    public void testDeleteByOrder_nums(){
        //接受参数
        String[] order_nums={"KB09010103","KB09010104"};
        int i=orderService.deleteOrders(order_nums);
        System.out.println("删除"+i+"条数据成功");
    }
}
