package web;

import com.alibaba.fastjson.JSON;
import pojo.AbnormalOrder;
import pojo.Feedback;
import service.AbnormalOrderService;
import service.impl.AbnormalOrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/abnormal/*")
public class AbnormalOrderServlet extends BaseServlet{
        //获取业务对象
        private AbnormalOrderService abnormalOrderService=new AbnormalOrderServiceImpl();

        //异常订单
        List<AbnormalOrder> abnormalOrders;

        //请求方式
        private String requestWay;
        //请求内容
        private String keyword;
        private int  currentPage;
        private int  pageSize;

        private String phone;
        private  String [] order_nums;

        String jsonString;

        //反馈订单对象
        private Feedback feedback;


        //查询
        public  void queryAbnormalOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取请求方式
                requestWay=request.getMethod();
                //获取客户端数据
                keyword=request.getParameter("keyword");
                currentPage=Integer.parseInt(request.getParameter("currentPage"));
                pageSize=Integer.parseInt(request.getParameter("pageSize"));


                //获取查询数据
                abnormalOrders=abnormalOrderService.query(keyword,currentPage,pageSize);
                System.out.println(abnormalOrders);
                //转化JSON数据
                jsonString= JSON.toJSONString(abnormalOrders);

                response.setContentType("text/json;charset=UTF-8");
                //响应JSON数据
                response.getWriter().write(jsonString);


        }

        //删除订单
        public void deleteAbnormalOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取请求方式
                requestWay=request.getMethod();
                //获取客户端数据
                order_nums=request.getParameterValues("order_nums");
                //修改显示状态
                abnormalOrderService.delete(order_nums);
                //再次调用查询
                queryAbnormalOrders(request,response);

        }


        //填写反馈意见并添加反馈订单,并修改处理状态
        public void addFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取json数据

                BufferedReader bufferedReader =request.getReader();
                jsonString=bufferedReader.readLine();
                System.out.println(jsonString);
                //转换为Feedback对象
                feedback=JSON.parseObject(jsonString,Feedback.class);
                abnormalOrderService.createFeedback(feedback);

        }


}
