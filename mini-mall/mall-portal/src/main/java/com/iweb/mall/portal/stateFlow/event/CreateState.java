package com.iweb.mall.portal.stateFlow.event;

import api.CommonResult;
import com.iweb.mall.portal.stateFlow.AbstractState;
import domain.Constants;
import org.springframework.stereotype.Component;

/**
 * @Description 订单创建状态
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.stateFlow.event
 */
@Component
public class CreateState extends AbstractState {
    @Override
    public CommonResult pay(String orderId, Enum<Constants.OrderState> currentState) {
        int res = ordersMapper.setState(orderId, Constants.OrderState.Paid.getCode());
        return res > 0 ? CommonResult.success("付款成功") : CommonResult.failed("付款失败");
    }

    @Override
    public CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed("未付款不能发货");
    }

    @Override
    public CommonResult done(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed("未付款不能完成交易");
    }

    @Override
    public CommonResult close(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed("未付款不能关闭交易");
    }

    @Override
    public CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState) {
        // TODO 取消订单事件
        return null;
    }
}
