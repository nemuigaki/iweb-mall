package com.iweb.mall.portal.controller;

import api.CommonResult;
import com.iweb.mall.portal.util.CacheUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 26/11/2023
 * @Package com.iweb.mall.portal.controller
 */
@RestController
@Api(tags = "HomeController", value = "订单接口")
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {
    @ApiOperation("获取首页信息")
    @RequestMapping(value = "/index-infos", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult indexInfo() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("carousels", CacheUtil.goodsMock.get("carousels"));
        res.put("hotGoodses", CacheUtil.goodsMock.get("hotGoodses"));
        res.put("newGoodses", CacheUtil.goodsMock.get("newGoodses"));
        res.put("recommendGoodses", CacheUtil.goodsMock.get("recommendGoodses"));
        return CommonResult.success(res);
    }
}
