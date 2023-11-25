package com.iweb.mall.portal.controller;

import api.CommonResult;
import com.iweb.mall.model.User;
import com.iweb.mall.portal.service.UserService;
import com.iweb.mall.portal.util.CacheUtil;
import com.iweb.mall.portal.util.ParameterValidateUtil;
import exception.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
    public CommonResult register(HttpServletRequest request,
                                 @RequestParam String username,//(required = false)可以不传该值，默认为null
                                 @RequestParam String password,
                                 @RequestParam String confirmPassword,//要设置的密码
                                 @RequestParam(required = false) String telephone,
                                 @RequestParam String authCode) {
        //验证用户名密码是否填写完整
        if (!ParameterValidateUtil.validate(username, password, confirmPassword,authCode)) {
            return CommonResult.validateFailed("表单输入不完整");
        }
        //验证用户两次输入的密码是否一致
        if (!password.equals(confirmPassword)){
            return CommonResult.failed("请确认两次输入的密码是相同的");
        }
        userService.register(username, password, telephone, authCode,request.getSession().getId());
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
        if (!token) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //Map<String, String> tokenMap = new HashMap<>();
        //tokenMap.put("token", token);
        //tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success("login success");
    }

    @ApiOperation("会员修改个人信息")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(
                              @RequestParam String username,
                              @RequestParam(required = false) String editedUsername,
                              @RequestParam String password,
                              @RequestParam(required = false) String editedPassword,//要设置的密码
                              @RequestParam(required = false) String reEditedPassword,
                              @RequestParam(required = false) String telephone) {
        if (!ParameterValidateUtil.validate(username, password)) {
            return CommonResult.validateFailed("表单输入不完整");
        }
        //如果用户填写了要改的密码，那么确认要更改的密码就不能为空
        if (editedUsername !=null && reEditedPassword == null){
            return CommonResult.validateFailed("确认要修改的密码不能为空");
        }
        //用户可以选择要修改密码，手机或者用户名，不修改的可以留空，但不能三者全部留空
        if (editedUsername == null && editedPassword == null && telephone == null){
            return CommonResult.validateFailed("请填写至少一项属性来修改");
        }
        userService.updatePassword(username,editedUsername,password,editedPassword,telephone);
        return CommonResult.success("修改成功");
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(HttpServletRequest request, HttpServletResponse response) {
        String authCode = userService.generateAuthCode(response);
        CacheUtil.authCodeCache.put(request.getSession().getId(), authCode);
        return CommonResult.success(authCode, "获取验证码成功");
    }

    @ApiOperation("根据用户名查询")
    @RequestMapping(value = "/getByUsername", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getByUsername(
            @RequestParam String username
    )
    {
        if (!ParameterValidateUtil.validate(username)) {
            return CommonResult.validateFailed("查询用户名不能为空");
        }
        userService.getByUsername(username);
        return CommonResult.success(null,"查询成功");
    }

    @ApiOperation("根据id查询用户")
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getById(
            @RequestParam String id
    )
    {
        if (!ParameterValidateUtil.validate(id)) {
            return CommonResult.validateFailed("查询ID不能为空");
        }
        userService.getById(id);
        return CommonResult.success(null,"查询成功");
    }

    @ApiOperation("根据用户名删除用户")
    @RequestMapping(value = "/deleteByUserName", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteByUserName(
            @RequestParam String username
    )
    {
        if (!ParameterValidateUtil.validate(username)) {
            return CommonResult.validateFailed("要删除的用户名不能为空");
        }
        userService.deleteUserByUsername(username);
        return CommonResult.success(null,"删除成功");
    }



    @ApiOperation("根据ID删除用户")
    @RequestMapping(value = "/deleteByUserId", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteByUserId(
            @RequestParam String id
    )
    {
        if (!ParameterValidateUtil.validate(id)) {
            return CommonResult.validateFailed("删除的用户id不能为空");
        }
        userService.deleteUserById(id);
        return CommonResult.success(null,"删除成功");
    }

    @ApiOperation("模糊查询")
    @RequestMapping(value = "/fuzzQuery", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult fuzzQuery(
            @RequestParam String key
    )
    {
        if (!ParameterValidateUtil.validate(key)) {
            return CommonResult.failed("key值不能为空值");
        }
        List<User> users = userService.fuzzQuery(key);
        return CommonResult.success(users,"查询成功");
    }
}
