package com.iweb.mall.portal.stateFlow.event;

import api.CommonResult;
import api.ResultCode;
import com.iweb.mall.portal.stateFlow.AbstractState;
import domain.Constants;
import org.springframework.stereotype.Component;

/**
 * @Description 发货状态
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow.event
 */
@Component
public class DeliverSate extends AbstractState {
    @Override
    public CommonResult pay(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "已发货, 不能继续支付");
    }

    @Override
    public CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "已发货， 不能重复操作");
    }

    @Override
    public CommonResult done(String orderId, Enum<Constants.OrderState> currentState) {
        int res = ordersMapper.setState(orderId, Constants.OrderState.TransactionClosure.getCode());
        return res > 0 ? CommonResult.success("交易成功") : CommonResult.failed("交易失败");
    }

    @Override
    public CommonResult close(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "已发货， 不能关闭交易");
    }

    @Override
    public CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "已发货, 不能取消订单");
    }
}
