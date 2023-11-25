package com.iweb.mall.mapper;

import com.iweb.mall.model.Shopping;
import com.iweb.mall.model.ShoppingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ShoppingMapper {
    long countByExample(ShoppingExample example);

    int deleteByExample(ShoppingExample example);

    int deleteByPrimaryKey(String id);

    int insert(Shopping row);

    int insertSelective(Shopping row);

    List<Shopping> selectByExample(ShoppingExample example);

    Shopping selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Shopping row, @Param("example") ShoppingExample example);

    int updateByExample(@Param("row") Shopping row, @Param("example") ShoppingExample example);

    int updateByPrimaryKeySelective(Shopping row);

    int updateByPrimaryKey(Shopping row);

    @Select("select * from shopping where orderid = #{orderid}")
    Shopping selectByOrderId(String orderId);
}