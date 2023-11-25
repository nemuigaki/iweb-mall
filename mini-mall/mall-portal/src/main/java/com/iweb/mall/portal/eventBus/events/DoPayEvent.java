package com.iweb.mall.portal.eventBus.events;

import com.iweb.mall.model.Orders;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.eventBus.events
 */
@Getter
@Setter
public class DoPayEvent extends ApplicationEvent {
    private Orders orders;

    public DoPayEvent(Object source, Orders orders) {
        super(source);
        this.orders = orders;
    }
}
