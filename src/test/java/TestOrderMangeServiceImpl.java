import org.junit.Test;
import pojo.Order;
import pojo.Paylist;
import pojo.pageBean.OrderManagePageBean;
import service.OrderMangeService;
import service.PaylistService;
import service.impl.OrderMangeServiceImpl;
import service.impl.PaylistServiceImpl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestOrderMangeServiceImpl {
    OrderMangeService orderMangeService = new OrderMangeServiceImpl();

    PaylistService ps = new PaylistServiceImpl();

    @Test
    public void testAddOther(){
        String order_num="4564555";
        String stu_num="3216894132";
        List<Paylist> list = ps.query(stu_num, 1, 1);
       for(Paylist p:list) {
           int i = ps.addOther(p, order_num);
           System.out.println(i);
       }
    }


    @Test
    public void testQuery() {
        String keyword = "";
        List<Paylist> payLists = ps.query(keyword, 1, 15);
        System.out.println(payLists);
    }

    @Test
    public void testAdd() {
        String stu_num = "4527";
        String stu_name = "zhou";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        String stu_class = "计科1班";
        float payment = 65454;
        Paylist paylist = new Paylist();
        paylist.setStu_num(stu_num);
        paylist.setStu_name(stu_name);
        paylist.setTime(time);
        paylist.setStu_class(stu_class);
        paylist.setPayment(payment);

        int i = ps.add(paylist);
        System.out.println(i);
    }


    @Test
    public void delete() {
        String[] stu_nums = {"321694132"};
        int i = ps.delete(stu_nums);
        System.out.println(i);

    }

    //测试修改金额业务
    @Test
    public void testModify() {
        String stu_num = "3216891532";
        int i = ps.modify(stu_num, 24);
        System.out.println(i);
    }

    //根据order_num删除
    @Test
    public void testDeleteByOrder_num() {
        //接受参数
        String order_num = "KB09010103";
        System.out.println("删除" + "个数据");
    }


    @Test
    //测试根据关键字模糊查询业务
    public void testQueryOrder() {
        OrderManagePageBean<Order> query = orderMangeService.query("5", 1, 3);
        System.out.println(query);



    }


}
