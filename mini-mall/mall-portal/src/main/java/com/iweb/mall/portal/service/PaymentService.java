package com.iweb.mall.portal.service;

import com.iweb.mall.model.Orders;
import com.iweb.mall.model.Payinfo;
import com.iweb.mall.portal.service.impl.PaymentServiceImpl;
import domain.Constants;

import java.util.HashMap;
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
    Map<Constants.PaymentUrl, String> doPay(Orders orders, HashMap<Constants.PaymentUrl, String> map);

    void callback(String orderId, String platformNumber);


    Payinfo getPayInfo(String orderId, String userId);

    Payinfo getPayInfoForAdmin(String orderId);

    Payinfo createPayInfo(Orders orders);

    boolean isPayed(String orderId, String userId);

    boolean isPayedForAdmin(String orderId);

    List<Payinfo> getPayInfosByUserId(String userId);
}
