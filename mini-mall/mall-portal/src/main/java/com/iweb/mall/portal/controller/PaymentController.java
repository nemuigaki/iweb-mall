package com.iweb.mall.portal.controller;

import api.CommonResult;
import com.iweb.mall.model.Payinfo;
import com.iweb.mall.portal.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 支付服务
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.controller
 */
@RestController
@Api(tags = "PaymentController", value = "支付接口")
@RequestMapping("/pay")
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @ApiOperation("支付成功回调")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult callback(@RequestParam String orderId,
                                 @RequestParam String platformNumber) {
        paymentService.callback(orderId, platformNumber);
        return CommonResult.success(null, "回调成功");
    }

    @ApiOperation("查询是否支付成功")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult isPayed(@RequestParam String orderId,
                                @RequestParam String userId) {
        boolean payed = paymentService.isPayed(orderId, userId);
        return CommonResult.success(payed);
    }

    @ApiOperation("查询订单的支付信息")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getPayInfoByOrderId(@RequestParam String orderId,
                                            @RequestParam String userId) {
        Payinfo payInfo = paymentService.getPayInfo(orderId, userId);
        return CommonResult.success(payInfo);
    }

    @ApiOperation("查询用户账户下的所有支付信息")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getPayInfosByUserId(@RequestParam String userId) {
        List<Payinfo> payInfos = paymentService.getPayInfosByUserId(userId);
        return CommonResult.success(payInfos);
    }
}
