package web;

import com.alibaba.fastjson.JSON;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
        //获取业务对象
        private UserService userService=new UserServiceImpl();

        //请求方式
        private String requestWay;
        //获取请求内容
        private String user_num;
        private String password;

        //用户类
        User user;
        //查询
        public  void queryOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取请求方式
                requestWay=request.getMethod();
                //获取客户端数据
                user_num=request.getParameter("user_num");
                password=request.getParameter("password");
                //判断验证返回用户对象
                user=userService.verifyLogin(user_num,password);
                //转化JSON数据
                String jsonString= JSON.toJSONString(user);

                response.setContentType("text/json;charset=UTF-8");
                //响应JSON数据
                response.getWriter().write(jsonString);

        }


}
