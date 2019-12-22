package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user(username,password,gender,address,job,wealth,telephone,introduction)" +
            "values(#{user.username},#{user.password},#{user.gender},#{user.address},#{user.job},#{user.wealth},#{user.telephone},#{user.introduction})")
    void insertUser(@Param("user") User user);

    @Select("select * from user where username = #{username}")
    User getUserByName(@Param("username") String username);

    @Select("select * from user where userID = #{userID}")
    User getUserById(@Param("userID") int userID);

    @Select("select * from user")
    List<User> getAllUser();

    @Delete("delete from user where userID = #{userID}")
    void deleteUser(@Param("userID") int userID);

    @Update("update user set username=#{user.username},gender=#{user.gender},address=#{user.address},job=#{user.job},telephone=#{user.telephone},intro=#{user.introduction}")
    void updateUser(@Param("user") User user);

    @Select("select password from user where userId=#{userID}")
    String getPassword(@Param("userID") int userID);

    @Update("update user set password=#{password} where userID=#{userID}")
    void updatePassword(@Param("password") String password, @Param("userID") int userID);

    @Select("select wealth from user where userID=#{userID}")
    int getWealth(@Param("userID") int userID);

    @Update("update user set wealth=#{wealth} where userID=#{userID}")
    void updateWealth(@Param("wealth") int wealth, @Param("userID") int userID);
}
