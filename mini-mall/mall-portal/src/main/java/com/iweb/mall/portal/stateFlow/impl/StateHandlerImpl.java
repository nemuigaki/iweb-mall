package com.iweb.mall.portal.stateFlow.impl;

import api.CommonResult;
import com.iweb.mall.portal.stateFlow.IStateHandler;
import com.iweb.mall.portal.stateFlow.StateConfig;
import domain.Constants;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow.impl
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {
    @Override
    public CommonResult pay(String orderId, Enum<Constants.OrderState> currentState) {
        return stateGroup.get(currentState).pay(orderId, currentState);
    }

    @Override
    public CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState) {
        return stateGroup.get(currentState).deliver(orderId, currentState);
    }

    @Override
    public CommonResult done(String orderId, Enum<Constants.OrderState> currentState) {
        return stateGroup.get(currentState).done(orderId, currentState);
    }

    @Override
    public CommonResult close(String orderId, Enum<Constants.OrderState> currentState) {
        return stateGroup.get(currentState).close(orderId, currentState);
    }

    @Override
    public CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState) {
        return stateGroup.get(currentState).cancel(orderId, currentState);
    }
}
