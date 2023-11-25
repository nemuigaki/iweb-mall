package com.iweb.mall.portal.controller;

import api.CommonResult;
import com.iweb.mall.mapper.CartMapper;
import com.iweb.mall.model.Cart;
import com.iweb.mall.model.Payinfo;
import com.iweb.mall.model.Shopping;
import com.iweb.mall.portal.eventBus.events.ShoppingEvent;
import com.iweb.mall.portal.service.PaymentService;
import com.iweb.mall.portal.util.CacheUtil;
import com.iweb.mall.portal.util.ParameterValidateUtil;
import domain.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;

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
    private CartMapper cartMapper;
    private final ApplicationEventPublisher publisher;

    @ApiOperation("支付成功回调")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult callback(@RequestParam String orderId,
                                 @RequestParam String platformNumber) {
        paymentService.callback(orderId, platformNumber);
        return CommonResult.success(null, "回调成功");
    }

    @ApiOperation("查询是否支付成功")
    @RequestMapping(value = "/isPayed", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult isPayed(@RequestParam String orderId,
                                @RequestParam String userId) {
        boolean payed = paymentService.isPayed(orderId, userId);
        return CommonResult.success(payed);
    }

    @ApiOperation("查询订单的支付信息")
    @RequestMapping(value = "/payInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getPayInfoByOrderId(@RequestParam String orderId,
                                            @RequestParam String userId) {
        Payinfo payInfo = paymentService.getPayInfo(orderId, userId);
        return CommonResult.success(payInfo);
    }

    @ApiOperation("查询用户账户下的所有支付信息")
    @RequestMapping(value = "/payInfos", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getPayInfosByUserId(@RequestParam String userId) {
        List<Payinfo> payInfos = paymentService.getPayInfosByUserId(userId);
        return CommonResult.success(payInfos);
    }

    @SneakyThrows
    @ApiOperation("测试下单支付流程")
    @RequestMapping(value = "/paymentTest", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult paymentTest(@RequestParam("cartId") String cartId) {
        List<Cart> carts = new ArrayList<>();
        System.out.println(carts);
        if (!ParameterValidateUtil.validate(cartId)) {
            return CommonResult.validateFailed("购物车数据不能为空");
        }
        carts.add(cartMapper.selectByPrimaryKey(cartId));
        Shopping shopping = new Shopping();
        shopping.setUserid("6129812");
        String orderId = "123123123";
        shopping.setOrderid(orderId);
        SynchronousQueue<Map<Constants.PaymentUrl, String>> map = new SynchronousQueue<>();
        CacheUtil.payMap.put(orderId, map);
        System.out.println("通知订单服务");
        publisher.publishEvent(new ShoppingEvent(this, carts, shopping));
        System.out.println("阻塞获取支付信息");
        Map<Constants.PaymentUrl, String> take = map.take();
        HashMap<String, Object> res = new HashMap<>();
        res.put("pay", take);
        res.put("order", CacheUtil.orderDetailsCache.get(orderId));
        System.out.println("开始返回订单支付信息");
        return CommonResult.success(res);
    }
}
