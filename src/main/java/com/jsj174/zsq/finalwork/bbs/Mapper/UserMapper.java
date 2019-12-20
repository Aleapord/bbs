package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user(userID,username,password,gender,address,job,wealth,telephone) " +
            "values(#{userID},#{username},#{password},#{gender},#{address},#{job},#{wealth},#{telephone)")
    void insertUser(User user);

    @Select("select * from user where name = #{name}")
    User getUserByName(@Param("name") String name);

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Select("select * from user")
    List<User> getAllUser();

    @Delete("delete from user where id = #{id}")
    void deleteUser(@Param("id") int id);
}
