package com.iweb.mall.portal.stateFlow;

import api.CommonResult;
import domain.Constants;

/**
 * @Description 状态处理接口
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow
 */
public interface IStateHandler {

    CommonResult pay(String orderId, Enum<Constants.OrderState> currentState);

    CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState);

    CommonResult done(String orderId, Enum<Constants.OrderState> currentState);

    CommonResult close(String orderId, Enum<Constants.OrderState> currentState);

    CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState);
}
