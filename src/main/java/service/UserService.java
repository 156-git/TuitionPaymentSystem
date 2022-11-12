package service;

import pojo.User;

public interface UserService {
    //验证登录
    User verifyLogin(String number,String password);

}
