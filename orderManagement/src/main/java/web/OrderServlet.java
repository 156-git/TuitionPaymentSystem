package web;

import com.alibaba.fastjson.JSON;
import pojo.Order;
import pojo.PageBean;
import service.impl.OrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders/*")
public class OrderServlet extends BaseServlet{
        //获取业务对象
        private OrderServiceImpl orderService=new OrderServiceImpl();

        //请求方式
        private String requestWay;
        private String keyword;
        private int  currentPage;
        private int  pageSize;
        //查询
        public  void queryOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                requestWay=request.getMethod();

                keyword=request.getParameter("keyword");
                currentPage=Integer.parseInt(request.getParameter("currentPage"));
                pageSize=Integer.parseInt(request.getParameter("pageSize"));

                PageBean<Order> pageBean=orderService.query(keyword,currentPage,pageSize);

                String jsonString= JSON.toJSONString(pageBean);

                response.setContentType("text/json;charset=UTF-8");

                response.getWriter().write(jsonString);


        }

        public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }

        public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }

        public void modifyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }


}
