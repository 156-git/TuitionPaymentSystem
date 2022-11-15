package web;

import javax.servlet.http.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {

        //获取uri路径
        String uri=req.getRequestURI();
        //获取方法索引
        int index=uri.lastIndexOf('/');
        //获取方法名
        String methodName=uri.substring(index+1);

        //获取本身字节码
        Class<? extends BaseServlet> cls=this.getClass();

        Method method = null;
        try {
            //获取方法对象
            method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //执行方法
            method.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
