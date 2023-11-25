package com.iweb.mall.mapper;

import com.iweb.mall.model.Orderitem;
import com.iweb.mall.model.OrderitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderitemMapper {
    long countByExample(OrderitemExample example);

    int deleteByExample(OrderitemExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orderitem row);

    int insertSelective(Orderitem row);

    List<Orderitem> selectByExample(OrderitemExample example);

    Orderitem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Orderitem row, @Param("example") OrderitemExample example);

    int updateByExample(@Param("row") Orderitem row, @Param("example") OrderitemExample example);

    int updateByPrimaryKeySelective(Orderitem row);

    int updateByPrimaryKey(Orderitem row);

    @Select("select * from orderitem where orderid = #{orderId}")
    List<Orderitem> selectByOrdersId(String orderId);

    @Select("select * from orderitem where userid = #{userId} and proname = #{proName}")
    List<Orderitem> selectOrderItemByProName(String userId, String proName);
}