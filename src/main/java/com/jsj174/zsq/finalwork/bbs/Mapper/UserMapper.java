package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user(username,password,gender,address,job,wealth,telephone,introduction) " +
            "values(#{username},#{password},#{gender},#{address},#{job},#{wealth},#{telephone),#{introduction}")
    void insertUser(User user);

    @Select("select * from user where username = #{username}")
    User getUserByName(@Param("username") String username);

    @Select("select * from user where userID = #{userID}")
    User getUserById(@Param("userID") int userID);

    @Select("select * from user")
    List<User> getAllUser();

    @Delete("delete from user where userID = #{userID}")
    void deleteUser(@Param("userID") int userID);

    @Update("update user set username=#{username},gender=#{gender},address=#{address},job=#{job},telephone=#{telephone},introduction=#{introduction}")
    void updateUser(User user);

    @Select("select password from user where userId=#{userID}")
    String getPassword(int userID);

    @Update("update user set password=#{password} where userID=#{userID}")
    void updatePassword(String password, int userID);

    @Select("select wealth from user where userID=#{userID}")
    int getWealth(int userID);

    @Update("update user set wealth=#{wealth} where userID=#{userID")
    void updateWealth(int wealth, int userID);
}
