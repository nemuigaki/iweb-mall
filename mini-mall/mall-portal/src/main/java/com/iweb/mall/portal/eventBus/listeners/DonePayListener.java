package com.iweb.mall.portal.eventBus.listeners;

import com.iweb.mall.portal.eventBus.events.DonePayEvent;
import com.iweb.mall.portal.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description 支付事件监听器
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.eventBus.listeners
 */
@Component
@AllArgsConstructor
public class DonePayListener {
    private OrderService orderService;

    @Async
    @EventListener(DonePayEvent.class)
    public void donePay(DonePayEvent paymentEvent) {
        orderService.afterPayed(paymentEvent.getOrderId());
    }
}
