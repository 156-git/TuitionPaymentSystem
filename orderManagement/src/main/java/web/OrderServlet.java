package web;

import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/*")
public class OrderServlet extends BaseServlet{
        //获取业务对象
        private OrderServiceImpl orderService=new OrderServiceImpl();

        //请求方式
        private String requestWay;

        public  void queryOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                request.setCharacterEncoding("UTF-8");
                requestWay=request.getMethod();



        }

        public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }

        public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }

        public void modifyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }


}
