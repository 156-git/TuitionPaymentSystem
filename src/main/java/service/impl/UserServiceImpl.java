package service.impl;

import Mapper.OrderManageMapper;
import Mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import pojo.pageBean.OrderManagePageBean;
import service.UserService;
import pojo.User;
import util.SqlSessionFactoryUtils;

public class UserServiceImpl<User> implements UserService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    static SqlSession sqlSession = factory.openSession(true);
    static UserMapper userMapper = sqlSession.getMapper(UserMapper.class);



    @Override
    public pojo.User verifyLogin(String number,String password) {

        return userMapper.selectUser(number, password);
    }
}
