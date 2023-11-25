package com.iweb.mall.portal.stateFlow;

import com.iweb.mall.portal.stateFlow.event.*;
import domain.Constants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 状态流转配置
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow
 */
public class StateConfig {
    @Resource
    private CreateState createState;

    @Resource
    private PaySate paySate;

    @Resource
    private DeliverSate deliverSate;

    @Resource
    private DoneSate doneSate;

    @Resource
    private CloseState closeState;

    @Resource
    private CancelState cancelState;

    protected Map<Enum<Constants.OrderState>, AbstractState> stateGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        stateGroup.put(Constants.OrderState.Created, createState);
        stateGroup.put(Constants.OrderState.Paid, paySate);
        stateGroup.put(Constants.OrderState.Delivered, deliverSate);
        stateGroup.put(Constants.OrderState.TransactionSuccessful, doneSate);
        stateGroup.put(Constants.OrderState.TransactionClosure, closeState);
        stateGroup.put(Constants.OrderState.Canceled, cancelState);
    }
}
