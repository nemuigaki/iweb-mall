package com.iweb.mall.portal.stateFlow.event;

import api.CommonResult;
import api.ResultCode;
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
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "已付款, 请勿重复支付");
    }

    @Override
    public CommonResult deliver(String orderId, Enum<Constants.OrderState> currentState) {
        int res = ordersMapper.setState(orderId, Constants.OrderState.Delivered.getCode());
        return res > 0 ? CommonResult.success("发货成功") : CommonResult.failed("发货失败");
    }

    @Override
    public CommonResult done(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "未支付, 交易不能设置为成功状态");
    }

    @Override
    public CommonResult close(String orderId, Enum<Constants.OrderState> currentState) {
        return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "未支付, 交易不能设置为关闭状态");
    }

    @Override
    public CommonResult cancel(String orderId, Enum<Constants.OrderState> currentState) {
        boolean res = ordersMapper.setState(orderId, Constants.OrderState.Canceled.getCode()) > 0;
        if (res) {
            // TODO 通知库存服务释放对应的库存, 以及收款服务退还支付部分
            return CommonResult.success("取消成功, 按付款路径返回款项");
        } else {
            return CommonResult.failed(ResultCode.ORDER_STATE_OPERATE_FAILED, "取消失败");
        }
    }
}
