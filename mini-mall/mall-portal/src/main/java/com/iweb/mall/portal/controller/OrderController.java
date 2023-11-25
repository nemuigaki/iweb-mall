package com.iweb.mall.portal.controller;

import api.CommonResult;
import com.iweb.mall.portal.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 25/11/2023
 * @Package com.iweb.mall.portal.controller
 */
@RestController
@Api(tags = "OrderController", value = "订单接口")
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @ApiOperation("根据用户id查询订单")
    @RequestMapping(value = "/getOrdersByUserId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOrdersByUserId(@RequestParam String userId) {
        return orderService.getOrderDetailsByUserId(userId);
    }

    @ApiOperation("根据订单id查询订单")
    @RequestMapping(value = "/getOrdersByOrderId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOrdersByOrderId(@RequestParam String orderId) {
        CommonResult orderDetail = orderService.getOrderDetails(orderId);
        return CommonResult.success(orderDetail, "查询成功");
    }

    @ApiOperation("发货后更新订单状态")
    @RequestMapping(value = "/updateStateByDelivered", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateStateByDelivered(@RequestParam String orderId) {
        return orderService.afterDelivered(orderId);
    }

    @ApiOperation("交易完成后更新订单状态")
    @RequestMapping(value = "/updateStateByDone", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateStateByDone(@RequestParam String orderId) {
        return orderService.afterDone(orderId);
    }

    @ApiOperation("交易关闭后更新订单状态")
    @RequestMapping(value = "/updateStateByClosed", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateStateByClosed(@RequestParam String orderId) {
        return orderService.afterClose(orderId);
    }

    @ApiOperation("交易取消后更新订单状态")
    @RequestMapping(value = "/updateStateByCanceled", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateStateByCanceled(@RequestParam String orderId) {
        return orderService.afterCanceled(orderId);
    }

    @ApiOperation("用户通过商品名称搜索订单")
    @RequestMapping(value = "/selectOrderItemsByProName", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult selectOrderItemsByProName(@RequestParam String userId,
                                                  @RequestParam String proName) {
        return orderService.selectOrderItemsByProName(userId, proName);
    }

}
