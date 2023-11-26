package com.iweb.mall.portal.stateFlow.event;

import api.CommonResult;
import api.ResultCode;
import com.iweb.mall.portal.stateFlow.AbstractState;
import domain.Constants;
import org.springframework.stereotype.Component;

/**
 * @Description 交易关闭状态
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow.event
 */
@Component
public class CloseState extends AbstractState {
    @Override
    public CommonResult pay(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已关闭, 不能支付");
    }

    @Override
    public CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已关闭, 不能发货");
    }

    @Override
    public CommonResult done(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已关闭, 不能完成交易");
    }

    @Override
    public CommonResult close(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已关闭, 不能重复关闭");
    }

    @Override
    public CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已关闭, 不能取消");
    }
}
