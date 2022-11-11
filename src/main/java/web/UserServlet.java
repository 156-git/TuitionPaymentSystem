package web;

import com.alibaba.fastjson.JSON;
import pojo.Order;
import pojo.pageBean.OrderManagePageBean;
import service.impl.OrderMangeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/*")
public class UserServlet extends BaseServlet{
        //获取业务对象
        private OrderMangeServiceImpl orderService=new OrderMangeServiceImpl();

        //请求方式
        private String requestWay;
        private String keyword;
        private int  currentPage;
        private int  pageSize;
        //查询
        public  void queryOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取请求方式
                requestWay=request.getMethod();
                //获取客户端数据
                keyword=request.getParameter("keyword");
                currentPage=Integer.parseInt(request.getParameter("currentPage"));
                pageSize=Integer.parseInt(request.getParameter("pageSize"));

                OrderManagePageBean<Order> orderManagePageBean =orderService.query(keyword,currentPage,pageSize);
                //转化JSON数据
                String jsonString= JSON.toJSONString(orderManagePageBean);

                response.setContentType("text/json;charset=UTF-8");
                //响应JSON数据
                response.getWriter().write(jsonString);


        }

        public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        }

        public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }

        public void modifyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }


}
