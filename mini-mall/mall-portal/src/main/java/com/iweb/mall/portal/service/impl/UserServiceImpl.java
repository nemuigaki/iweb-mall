package com.iweb.mall.portal.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.iweb.mall.mapper.UserMapper;
import com.iweb.mall.model.User;
import com.iweb.mall.portal.service.UserService;
import com.iweb.mall.portal.util.CacheUtil;
import exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 用户管理
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.portal.service.impl
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名称
     * @return User 用户实体
     */
    @Override
    public User getByUsername(String username) {
        return null;
        //return userMapper.selectByUsername(username);
    }

    @Override
    public boolean login(String username, String password, String code, String sessionId) {
        String codeInCache = CacheUtil.authCodeCache.get(sessionId);
        if (StrUtil.isEmpty(codeInCache)) {
            throw new ApiException("验证码错误");
        }
        User user = userMapper.selectByUsername(username);
        //TODO 密码加密
        return !ObjectUtil.isEmpty(user) && user.getPassword().equals(password);
    }

    /**
     * 根据用户编号获取用户
     *
     * @param id 用户id
     * @return User 用户实体
     */
    @Override
    public User getById(Long id) {
        return null;
    }

    /**
     * 用户注册
     *
     * @param username  用户名称
     * @param password  密码
     * @param telephone 手机号
     * @param authCode  验证码
     */
    @Override
    public void register(String username, String password, String telephone, String authCode) {

    }

    /**
     * 生成验证码
     */
    @Override
    public String generateAuthCode(HttpServletResponse response) {
        // HuTool定义图形验证码的长和宽,验证码的位数，干扰线的条数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 10);
        String code = lineCaptcha.getCode();
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            throw new ApiException("generate authCode failed");
        }
        return code;
    }

    /**
     * 修改密码
     *
     * @param telephone 手机号
     * @param password  新密码密码
     * @param authCode  验证码
     */
    @Override
    public void updatePassword(String telephone, String password, String authCode) {

    }
}
