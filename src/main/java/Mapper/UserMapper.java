package Mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {
    User selectUser(@Param("number")String number, @Param("password")String password);


}
