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
        OrderServiceImpl orderService=new OrderServiceImpl();

        public  void queryOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        }

        public void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        }

        public void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        }


}
