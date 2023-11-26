package com.iweb.mall.portal.eventBus.listeners;

import com.iweb.mall.model.Orders;
import com.iweb.mall.portal.eventBus.events.DoPayEvent;
import com.iweb.mall.portal.service.PaymentService;
import com.iweb.mall.portal.service.impl.PaymentServiceImpl;
import com.iweb.mall.portal.util.CacheUtil;
import domain.Constants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.SynchronousQueue;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.eventBus.listeners
 */

@Component
@AllArgsConstructor
public class DoPayListener {
    private PaymentService paymentService;

    @SneakyThrows
    @Async
    @EventListener(DoPayEvent.class)
    public void doPay(DoPayEvent doPayEvent) {
        Orders orders = doPayEvent.getOrders();
        SynchronousQueue<Map<Constants.PaymentUrl, String>> map = CacheUtil.payMap.get(orders.getId());
        Map<Constants.PaymentUrl, String> payInfoStringMap = paymentService.doPay(orders, doPayEvent.getMap());
        map.put(payInfoStringMap);
    }
}
