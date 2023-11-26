package com.iweb.mall.portal.stateFlow.event;

import api.CommonResult;
import api.ResultCode;
import com.iweb.mall.portal.stateFlow.AbstractState;
import domain.Constants;
import org.springframework.stereotype.Component;

/**
 * @Description 交易成功状态
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow.event
 */
@Component
public class DoneSate extends AbstractState {
    @Override
    public CommonResult pay(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已完成, 不能支付");
    }

    @Override
    public CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已完成, 不能发货");
    }

    @Override
    public CommonResult done(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已完成, 不能重复结束");
    }

    @Override
    public CommonResult close(String orderId, Enum<Constants.OrderState> currentState) {
        int res = ordersMapper.setState(orderId, Constants.OrderState.TransactionClosure.getCode());
        return res > 0 ? CommonResult.success("交易关闭成功") : CommonResult.failed("交易关闭失败");
    }

    @Override
    public CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "交易已完成, 不能取消");
    }
}
