package com.iweb.mall.portal.controller;

import api.CommonResult;
import com.iweb.mall.portal.service.UserService;
import com.iweb.mall.portal.util.CacheUtil;
import com.iweb.mall.portal.util.ParameterValidateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 用户控制器
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.portal.controller
 */
@RestController
// 接口文档
@Api(tags = "UserController")
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @ApiOperation("会员注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        userService.register(username, password, telephone, authCode);
        return CommonResult.success(null, "注册成功");
    }

    @ApiOperation("会员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(HttpServletRequest request,
                              @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String code) {
        if (!ParameterValidateUtil.validate(username, password, code)) {
            return CommonResult.validateFailed("表单输入不完整");
        }

        boolean token = userService.login(username, password, code, request.getSession().getId());
        if (token) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //Map<String, String> tokenMap = new HashMap<>();
        //tokenMap.put("token", token);
        //tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success("login success");
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(HttpServletRequest request, HttpServletResponse response) {
        String authCode = userService.generateAuthCode(response);
        CacheUtil.authCodeCache.put(request.getSession().getId(), authCode);
        return CommonResult.success(authCode, "获取验证码成功");
    }
}
