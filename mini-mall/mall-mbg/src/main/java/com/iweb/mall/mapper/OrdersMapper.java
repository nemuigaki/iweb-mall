package com.iweb.mall.mapper;

import com.iweb.mall.model.Orders;
import com.iweb.mall.model.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orders row);

    int insertSelective(Orders row);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Orders row, @Param("example") OrdersExample example);

    int updateByExample(@Param("row") Orders row, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders row);

    int updateByPrimaryKey(Orders row);

    @Select("select * from orderitem where userid = #{userId};")
    List<Orders> selectByUserId(String userId);

    @Update("update orders set status = #{state} where id = #{orderId}")
    int setState(String orderId, int state);
}