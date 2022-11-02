package service;

import Mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.SqlSessionFactoryUtils;

public class OrderService {
    SqlSessionFactory factory=SqlSessionFactoryUtils.getSqlSessionFactory();
    SqlSession sqlSession=factory.openSession();

    //查询总金额
    public float queryTotalAmount(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        return mapper.selectTotalAmount();
    }



}
