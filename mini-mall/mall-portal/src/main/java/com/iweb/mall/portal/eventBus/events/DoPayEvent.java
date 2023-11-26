package com.iweb.mall.portal.eventBus.events;

import com.iweb.mall.model.Orders;
import domain.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.HashMap;

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
    private HashMap<Constants.PaymentUrl, String> map;

    public DoPayEvent(Object source, Orders orders, HashMap<Constants.PaymentUrl, String> map) {
        super(source);
        this.orders = orders;
        this.map = map;
    }
}
