import Mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Orders;
import service.OrderService;

import java.io.IOException;
import java.io.InputStream;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TestService {



    //测试查询总金额方法
    @Test
    public void testTotalAmount() {
        OrderService orderService = new OrderService();
        float f = orderService.queryTotalAmount();
        System.out.println(f);
    }

    @Test
    public void testAddOrder() throws IOException {

        //接受参数
        String order_num = "20221161546";
        String stu_num = "2021666";
        String stu_name = "zhou";
        String stu_class = "六班";
        float stu_money = 2222;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stu_time = sdf.format(date);
        int order_state = 1;

//        2.封装对象
        Orders order = new Orders();
        order.setOrder_num(order_num);
        order.setStu_num(stu_num);
        order.setStu_name(stu_name);
        order.setStu_class(stu_class);
        order.setStu_money(stu_money);
        order.setOrder_time(stu_time);
        order.setOrder_state(order_state);

        //加载mybatis-config.xml配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象，用它来执行sql，自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //获取OrderMapper接口的代理对象
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        orderMapper.addOrder(order);

        //释放资源
        sqlSession.close();
    }

    //根据order_seq删除
    @Test
    public void testDeleteByOrder_seq() throws IOException {
        //接受参数
        int order_seq=5;

        //加载mybatis-config.xml配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象，用它来执行sql，自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //获取userMapper接口的代理对象
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        orderMapper.deleteByOrder_seq(order_seq);

        //释放资源
        sqlSession.close();
    }


    //根据order_seqs批量删除
    @Test
    public void testDeleteByOrder_seqs() throws IOException {
        //接受参数
        int[] order_seqs= {4,6};

        //加载mybatis-config.xml配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象，用它来执行sql，自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //获取userMapper接口的代理对象
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        orderMapper.deleteByOrder_seqs(order_seqs);

        //释放资源
        sqlSession.close();
    }
}
