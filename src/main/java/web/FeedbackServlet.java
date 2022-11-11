package web;

import service.impl.OrderMangeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/*")
public class FeedbackServlet extends BaseServlet{
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



        }

        public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        }

        public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }

        public void modifyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        }


}
