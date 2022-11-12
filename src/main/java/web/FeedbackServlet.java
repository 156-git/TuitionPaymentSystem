package web;

import com.alibaba.fastjson.JSON;
import pojo.Feedback;
import service.FeedbackService;
import service.impl.FeedbackServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/feedback/*")
public class FeedbackServlet extends BaseServlet{
        //获取业务对象
        private FeedbackService feedbackService=new FeedbackServiceImpl();

        //请求方式
        private String requestWay;
        //获取参数内容
        private String keyword;
        private int  currentPage;
        private int  pageSize;

        private String [] nums;

        private String order_num;

        private String content;

        //一系列
        List<Feedback> feedbacks;

        //JSON数据
        private String jsonString;

        //查询
        public  void queryFeedbacks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取请求方式
                requestWay=request.getMethod();
                //获取客户端数据
                keyword=request.getParameter("keyword");
                currentPage=Integer.parseInt(request.getParameter("currentPage"));
                pageSize=Integer.parseInt(request.getParameter("pageSize"));

                //获取查询数据
                feedbacks=feedbackService.query(keyword,currentPage,pageSize);
                //转化JSON数据
                jsonString= JSON.toJSONString(feedbacks);

                response.setContentType("text/json;charset=UTF-8");
                //响应JSON数据
                response.getWriter().write(jsonString);

        }


        //修改显示状态，实现逻辑删除
        public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
               //获取订单数组
                nums=request.getParameterValues("nums");
                feedbackService.delete(nums);

        }


        //处理，修改订单处理状态
        public void modifyOrder_state(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                order_num=request.getParameter("order_num");
                feedbackService.modifyFdbkState(order_num);

        }

        //修改添加反馈内容
        public void modifyCon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                order_num=request.getParameter("order_num");
                content=request.getParameter("feedbackcontent");
                feedbackService.addFdback(order_num,content);
        }


}
