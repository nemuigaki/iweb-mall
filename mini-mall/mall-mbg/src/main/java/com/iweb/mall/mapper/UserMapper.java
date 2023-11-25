package com.iweb.mall.mapper;

import com.iweb.mall.model.User;
import com.iweb.mall.model.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User row);

    int insertSelective(User row);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    int updateByExample(@Param("row") User row, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);

    User selectByUsername(String username);

    @Update("update user set password = #{passwd} where username = #{username};")
    int updateUserPasswd(String username, String passwd);
    @Update("update user set phone = #{telephone} where username = #{username};")
    int updateTelephone(String username, String telephone);
    @Update("update user set username = #{editedUsername} where username = #{username};")
    int updateUsername(String username, String editedUsername);
    @Delete("delete from user where username=#{username}")
    int deleteByUserName(String username);

    //模糊查询
    @Select("select * from user where username like concat('%',#{key},'%')")
    List<User> fuzzQuery(String key);

}