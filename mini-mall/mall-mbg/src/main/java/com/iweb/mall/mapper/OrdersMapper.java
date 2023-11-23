package com.iweb.mall.mapper;

import com.iweb.mall.model.Orders;
import com.iweb.mall.model.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}