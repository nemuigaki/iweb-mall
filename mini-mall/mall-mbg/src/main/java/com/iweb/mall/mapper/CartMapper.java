package com.iweb.mall.mapper;

import com.iweb.mall.model.Cart;
import com.iweb.mall.model.CartExample;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface CartMapper {
    long countByExample(CartExample example);//统计数量
    int deleteByExample(CartExample example);//删除数据
    int deleteByPrimaryKey(String id);//通过id删除数据
    int insertSelective(Cart row);//插入数据
    List<Cart> selectByExample(CartExample example);
    Cart selectByPrimaryKey(String id);
    int updateByExampleSelective(@Param("row") Cart row, @Param("example") CartExample example);
    int updateByExample(@Param("row") Cart row, @Param("example") CartExample example);
    int updateByPrimaryKeySelective(Cart row);
    int updateByPrimaryKey(Cart row);//根据id更新数据

    @Select("select * from cart where userid=#{userid} and proid=#{proid}")
    Cart findByUseridAndProid(@Param("userid") String userid,@Param("proid") String proid);

    //更新购买的数量
    @Update("update cart set quantity = quantity + #{quantity} where userid = #{userid}")
    Integer update(Integer quantity , String userid);

//    @Insert("insert into cart (id,userid,proid,quantity,proPrice) value(#{id},#{userid},#{proid},#{quantity},#{proPrice})")
    Integer insert(Cart cart);

    @Select("select * from cart where userid=#{userid} proid=#{proid}")
    Cart findByProid(String userid,String proid);

    @Delete("delete * from cart")
    void deleteAll(String id);

    @Select("select * from cart where userid=#{userid}")
    List<Cart> selectList(@Param("userid") String userid);

    @Select("select * from cart where id=#{id}")
    Cart selectByid(String id);

    @Update("update cart set checked=#{checked} where userid =#{userid} and proid=#{proid}")
    Integer selectOrNot(@Param("userid") String userid,
                        @Param("proid") String proid,
                        @Param("checked") Integer checked);

}