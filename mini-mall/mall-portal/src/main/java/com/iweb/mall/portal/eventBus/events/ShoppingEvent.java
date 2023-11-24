package com.iweb.mall.portal.eventBus.events;

import com.iweb.mall.model.Cart;
import com.iweb.mall.model.Payinfo;
import com.iweb.mall.model.Product;
import com.iweb.mall.model.Shopping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @Description 下单事件 通知订单服务初始化订单信息和支付服务
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.eventBus.events
 */
@Getter
@Setter
public class ShoppingEvent extends ApplicationEvent {
    private List<Cart> cartList;
    private Shopping shopping;

    public ShoppingEvent(Object source, List<Cart> cartList, Shopping shopping) {
        super(source);
        this.cartList = cartList;
        this.shopping= shopping;
    }
}
