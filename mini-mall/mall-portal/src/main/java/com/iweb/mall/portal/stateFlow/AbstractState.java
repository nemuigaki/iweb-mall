package com.iweb.mall.portal.stateFlow;

import api.CommonResult;
import com.iweb.mall.mapper.OrdersMapper;
import domain.Constants;

import javax.annotation.Resource;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow
 */
public abstract class AbstractState {
    @Resource
    protected OrdersMapper ordersMapper;


    public abstract CommonResult pay(String orderId, Enum<Constants.OrderState> currentState);

    public abstract CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState);

    public abstract CommonResult done(String orderId, Enum<Constants.OrderState> currentState);

    public abstract CommonResult close(String orderId, Enum<Constants.OrderState> currentState);

    public abstract CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState);
}
