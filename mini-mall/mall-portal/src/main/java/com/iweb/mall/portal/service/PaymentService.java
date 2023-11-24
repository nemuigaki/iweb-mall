package com.iweb.mall.portal.service;

import com.iweb.mall.model.Orders;
import com.iweb.mall.model.Payinfo;
import com.iweb.mall.portal.service.impl.PaymentServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.service
 */
public interface PaymentService {
    Map<PaymentServiceImpl.PaymentUrl, String> doPay(Orders orders);

    void callback(String orderId);

    Payinfo getPayInfo(String orderId);

    Payinfo createPayInfo(Orders orders);

    boolean isPayed(String orderId);

    List<Payinfo> getPayInfosByUserId(String userId);
}
