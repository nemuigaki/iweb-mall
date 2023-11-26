package com.iweb.mall.portal.service;

import com.iweb.mall.model.Cart;

import java.util.List;

public interface CartService {

    List<Cart> addToCart(String id,String userid, String proid, Integer quantity);

    List<Cart> delete(String id,String userid,String proid);

    List<Cart> list(String userid);

    List<Cart> update(String userid, String proid, Integer quantity);

    List<Cart> checked(String userid,String proid,Integer checked);

    //List<Cart> payment(Integer checked);

}
