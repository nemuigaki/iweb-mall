package com.iweb.mall.mapper;

import com.iweb.mall.model.Payinfo;
import com.iweb.mall.model.PayinfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PayinfoMapper {
    long countByExample(PayinfoExample example);

    int deleteByExample(PayinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Payinfo row);

    int insertSelective(Payinfo row);

    List<Payinfo> selectByExample(PayinfoExample example);

    Payinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Payinfo row, @Param("example") PayinfoExample example);

    int updateByExample(@Param("row") Payinfo row, @Param("example") PayinfoExample example);

    int updateByPrimaryKeySelective(Payinfo row);

    int updateByPrimaryKey(Payinfo row);

    @Select("select * from payinfo where orderid = #{orderId}")
    Payinfo selectByOrderId(String orderId);

    @Select("select * from payinfo where user() = #{userId}")
    List<Payinfo> selectByUserId(String userId);
}