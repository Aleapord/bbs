package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user(username,password,gender,address,job,wealth,telephone) " +
            "values(#{username},#{password},#{gender},#{address},#{job},#{wealth},#{telephone)")
    void insertUser(User user);

    @Select("select * from user where name = #{name}")
    User getUserByName(@Param("name") String name);

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Select("select * from user")
    List<User> getAllUser();

    @Delete("delete from user where id = #{id}")
    void deleteUser(@Param("id") int id);

    @Update("update user set username=#{username},gender=#{gender},address=#{address},job=#{job},telephone=#{telephone}")
    void updateUser(User user);

    @Select("select password from user where userId=#{userID}")
    String getPassword(int userID);

    @Update("update user set password=#{password} where userID=#{userID}")
    void updatePassword(String password,int userID);

    @Select("select wealth from user where userID=#{userID}")
    int getWealth(int userID);

    @Update("update user set wealth=#{wealth} where userID=#{userID")
    void updateWealth(int wealth,int userID);
}
