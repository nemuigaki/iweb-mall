package com.iweb.mall.portal.stateFlow.event;

import api.CommonResult;
import com.iweb.mall.portal.stateFlow.AbstractState;
import domain.Constants;
import org.springframework.stereotype.Component;

/**
 * @Description 付款成功状态
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow.event
 */
@Component
public class PaySate extends AbstractState {
    @Override
    public CommonResult pay(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed("已付款, 请勿重复支付");
    }

    @Override
    public CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState) {
        int res = ordersMapper.setState(orderId, Constants.OrderState.Delivered.getCode());
        return res > 0 ? CommonResult.success("发货成功") : CommonResult.failed("发货失败");
    }

    @Override
    public CommonResult done(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed("未支付, 交易不能设置为成功状态");
    }

    @Override
    public CommonResult close(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed("未支付, 交易不能设置为关闭状态");
    }

    @Override
    public CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState) {
        // TODO 支付成功未发货可以取消订单
        return null;
    }
}
