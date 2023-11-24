package com.iweb.mall.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.iweb.mall.mapper.PayinfoMapper;
import com.iweb.mall.model.Orders;
import com.iweb.mall.model.Payinfo;
import com.iweb.mall.portal.eventBus.events.DonePayEvent;
import com.iweb.mall.portal.service.PaymentService;
import com.iweb.mall.portal.util.QRCodeUtil;
import com.iweb.mall.portal.util.idSupport.IIdGenerator;
import domain.Constants;
import exception.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.service.impl
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Value("${server.port}")
    private String port;
    private final String uriPrefix = "http://localhost:" + port;

    private final PayinfoMapper payinfoMapper;

    private final Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    private final ApplicationEventPublisher publisher;


    public PaymentServiceImpl(PayinfoMapper payinfoMapper, Map<Constants.Ids, IIdGenerator> idGeneratorMap, ApplicationEventPublisher publisher) {
        this.payinfoMapper = payinfoMapper;
        this.idGeneratorMap = idGeneratorMap;
        this.publisher = publisher;
    }

    @Override
    public Map<PaymentServiceImpl.PaymentUrl, String> doPay(Orders orders) {
        int payment = orders.getPayment().intValue() + orders.getPostage();
        String platformNumber = String.valueOf(idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        String paymentUrl = uriPrefix + "/pay/callback?orderId=" + orders.getId() + "&platformNumber=" + platformNumber + "&payment=" + payment;
        String base64QRCode = QRCodeUtil.getBase64QRCode(paymentUrl);
        HashMap<PaymentUrl, String> map = new HashMap<>();
        map.put(PaymentUrl.Url, paymentUrl);
        map.put(PaymentUrl.BASE64, base64QRCode);
        return map;
    }

    @Override
    public void callback(String orderId, String platformNumber) {
        Payinfo payInfo = getPayInfoForAdmin(orderId);
        if (ObjectUtil.isNotEmpty(payInfo)) {
            payInfo.setPlatformstatus("已支付");
            payInfo.setPlatformnumber(platformNumber);
            payinfoMapper.updateByPrimaryKey(payInfo);
            publisher.publishEvent(new DonePayEvent(this, orderId));
        }
    }

    @Override
    public Payinfo getPayInfo(String orderId, String userId) {
        Payinfo payinfo = payinfoMapper.selectByOrderId(orderId);
        if (ObjectUtil.isNotEmpty(payinfo)) {
            if (!payinfo.getUserid().equals(userId)) {
                throw new ApiException("该用户试图访问不属于他的支付信息!");
            }
            return payinfo;
        }
        return null;
    }

    @Override
    public Payinfo getPayInfoForAdmin(String orderId) {
        return payinfoMapper.selectByOrderId(orderId);
    }

    @Override
    public Payinfo createPayInfo(Orders orders) {
        Payinfo payinfo = new Payinfo();
        payinfo.setId(String.valueOf(idGeneratorMap.get(Constants.Ids.SnowFlake).nextId()));
        payinfo.setOrderid(orders.getId());
        payinfo.setUserid(orders.getUserid());
        payinfo.setPayplatform(1);
        payinfo.setPlatformstatus("未支付");
        Date date = new Date();
        payinfo.setCreatetime(date);
        payinfo.setUpdatetime(date);
        payinfoMapper.insert(payinfo);
        return payinfo;
    }

    @Override
    public boolean isPayed(String orderId, String userId) {
        Payinfo payinfo = getPayInfo(orderId, userId);

        //return ObjectUtil.isNotEmpty(payinfo.getPlatformstatus());
        return ObjectUtil.isNotEmpty(payinfo.getPlatformnumber());

    }

    @Override
    public boolean isPayedForAdmin(String orderId) {
        Payinfo payinfo = payinfoMapper.selectByOrderId(orderId);
        if (ObjectUtil.isNotEmpty(payinfo)) {
            //return ObjectUtil.isNotEmpty(payinfo.getPlatformstatus());
            return ObjectUtil.isNotEmpty(payinfo.getPlatformnumber());
        }
        return false;
    }

    @Override
    public List<Payinfo> getPayInfosByUserId(String userId) {
        return payinfoMapper.selectByUserId(userId);
    }

    public enum PaymentUrl {
        Url,
        BASE64
    }
}
