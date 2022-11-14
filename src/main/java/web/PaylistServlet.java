package web;

import com.alibaba.fastjson.JSON;
import pojo.Paylist;
import service.PaylistService;
import service.impl.PaylistServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/paylist/*")
public class PaylistServlet extends BaseServlet{
        //获取业务对象
        private PaylistService paylistService=new PaylistServiceImpl();

        //请求方式
        private String requestWay;

        //请求参数内容
        private String keyword;
        private int  currentPage;
        private int  pageSize;

        private String order_num;
        private String [] order_nums;

        private float payment;

        //返回系列缴费订单
        private List<Paylist> paylists;
        private Paylist paylist;

        //JSON字符串
        private String jsonString;

        //查询
        public  void queryPaylists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取请求方式
                requestWay=request.getMethod();
                //获取客户端数据
                keyword=request.getParameter("keyword");
                currentPage=Integer.parseInt(request.getParameter("currentPage"));
                pageSize=Integer.parseInt(request.getParameter("pageSize"));

                paylists=paylistService.query(keyword,currentPage,pageSize);
                //转化JSON数据
                jsonString= JSON.toJSONString(paylists);

                response.setContentType("text/json;charset=UTF-8");
                //响应JSON数据
                response.getWriter().write(jsonString);

        }

        //逻辑删除
        public void deletePaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

                order_nums=request.getParameterValues("order_nums");
                paylistService.delete(order_nums);
                queryPaylists(request,response);
        }

        //添加缴费订单
        public void addPaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                //获取json字符串
                jsonString=request.getParameter("paylist");
                //转换成paylist对象
                paylist=JSON.parseObject(jsonString,Paylist.class);
                //调用增加方法方法
                paylistService.add(paylist);
                queryPaylists(request,response);
        }



        //修改缴费金额
        public void modifyPaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                order_num=request.getParameter("order_num");
                payment=Float.parseFloat(request.getParameter("payment"));
                paylistService.modify(order_num,payment);
        }


}
