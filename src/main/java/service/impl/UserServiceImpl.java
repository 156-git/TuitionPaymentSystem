package service.impl;

import Mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.UserService;
import pojo.User;
import util.SqlSessionFactoryUtils;

public class UserServiceImpl implements UserService {
    static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    static SqlSession sqlSession = factory.openSession(true);
    static UserMapper userMapper = sqlSession.getMapper(UserMapper.class);



    @Override
    public User verifyLogin(String number,String password) {

        return userMapper.selectUser(number, password);
    }
}
