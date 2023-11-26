package com.iweb.mall.portal;

import api.CommonResult;
import com.iweb.mall.mapper.CartMapper;
import com.iweb.mall.mapper.UserMapper;
import com.iweb.mall.model.Cart;
import com.iweb.mall.portal.service.CartService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.aspectj.bridge.IMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CartMapperTest {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartService cartService;
    @Test
    public void insert() {
        cartService.addToCart("dsfsvd","wqwq","qweq",1);
    }
    @Test
    public void delete(){
        Cart cart = new Cart();
        cartService.delete("asdaf","saf","dgs");
    }
    @Test
    public void updata(){
        Cart cart = new Cart();
        cartService.update("saf","dgs",5);
        System.out.println(CommonResult.success(cart).getMessage());
    }

    @Test
    public void list(){
        List<Cart> wqwq = cartService.list("saf");
        System.out.println(wqwq);
    }
    @Test
    public void checked(){
        cartService.checked("wqwq","dgs",1);
    }
}

