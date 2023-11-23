package com.iweb.mall.mapper;

import com.iweb.mall.model.Cart;
import com.iweb.mall.model.CartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(String id);

    int insert(Cart row);

    int insertSelective(Cart row);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Cart row, @Param("example") CartExample example);

    int updateByExample(@Param("row") Cart row, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart row);

    int updateByPrimaryKey(Cart row);
}