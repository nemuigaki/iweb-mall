package com.iweb.mall.portal.eventBus.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @Description 支付事件 支付完成后通知订单服务更新订单状态
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.eventBus.events
 */
@Getter
@Setter
public class DonePayEvent extends ApplicationEvent {
    private String orderId;

    public DonePayEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
