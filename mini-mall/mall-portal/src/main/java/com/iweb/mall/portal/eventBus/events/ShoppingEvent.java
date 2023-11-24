package com.iweb.mall.portal.eventBus.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

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
    private String orderId;

    public ShoppingEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
