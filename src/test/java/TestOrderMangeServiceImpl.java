import org.junit.Test;
import pojo.AbnormalOrder;
import pojo.Feedback;
import pojo.Order;
import pojo.Paylist;
import pojo.pageBean.OrderManagePageBean;
import service.FeedbackService;
import service.OrderMangeService;
import service.PaylistService;
import service.impl.AbnormalOrderServiceImpl;
import service.impl.FeedbackServiceImpl;
import service.impl.OrderMangeServiceImpl;
import service.impl.PaylistServiceImpl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestOrderMangeServiceImpl {
    OrderMangeService orderMangeService = new OrderMangeServiceImpl();
    AbnormalOrderServiceImpl abnormalOrderService=new AbnormalOrderServiceImpl();

    FeedbackService feedbackService=new FeedbackServiceImpl();

    Feedback feedback=new Feedback();


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
        String stu_num = "45";
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
        OrderManagePageBean<Order> query = orderMangeService.query("软", 1, 3);
        System.out.println(query);

    }




    /************************************************************************************/
    //测试异常订单查询
    @Test
    public void testQueryAbnormalOrder(){

        List<AbnormalOrder> abnormalOrders=abnormalOrderService.query("软",1,3);
        System.out.println(abnormalOrders);
    }


    //测试填写异常订单反馈，生成

    @Test
    public void testAbnormalOrderCreateFeedbackService() {
        feedback.setFeedbackContent("hello feedback3");
        feedback.setOrder_num("1345");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=simpleDateFormat.format(date);
        feedback.setTime(time);
        feedback.setPhone("18169755401");
        feedback.setStu_name("张杰");
        feedback.setState(0);
        feedback.setStu_num("28210250260209");
        int i=abnormalOrderService.createFeedback(feedback);
        System.out.println(i);

    }


    //测试删除已处理订单

    @Test
    public void testDeleteAbnormalOrderService() {
        String [] order_nums={"kb001","a"};
        int i=abnormalOrderService.delete(order_nums);
        System.out.println(i);
    }



    /******************反馈订单********************/
    //删除
    @Test
    public void testDeleteFeedbackOrderService() {
        String [] order_nums={"123456"};
        int i=feedbackService.delete(order_nums);
        System.out.println(i);
    }

    //查询
    @Test
    public void testQueryFeedbackOrderService() {
        List<Feedback> query = feedbackService.query("刘", 1, 5);
        System.out.println(query);
    }

    //查询
    @Test
    public void testModifyFeedbackOrderService() {
        int i = feedbackService.modifyFdbkState("123456");
        System.out.println(i);

    }

    //添加反馈内容
    @Test
    public void testAddFeedbackOrderConService() {
        int i = feedbackService.addFdback("123456", "come on");
        System.out.println(i);

    }

}
