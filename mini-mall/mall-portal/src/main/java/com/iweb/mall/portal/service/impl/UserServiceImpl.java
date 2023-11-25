package com.iweb.mall.portal.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.iweb.mall.mapper.UserMapper;
import com.iweb.mall.model.User;
import com.iweb.mall.portal.service.UserService;
import com.iweb.mall.portal.util.CacheUtil;
import com.iweb.mall.portal.util.MD5Util;
import com.iweb.mall.portal.util.UserUtil;
import domain.Constants;
import exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import com.iweb.mall.portal.util.idSupport.IIdGenerator;

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
    private Map<Constants.Ids, IIdGenerator> iIdGeneratorMap;

    /**
     * 登录
     * @return boolean 返回处理结果，true为成功
     */
    @Override
    public boolean login(String username, String password, String code, String sessionId) {
        /*String codeInCache = CacheUtil.authCodeCache.get(sessionId);
        if (StrUtil.isEmpty(codeInCache) || !codeInCache.equals(code)) {
            throw new ApiException("验证码错误");
        }*/
        User user = userMapper.selectByUsername(username);
        //TODO 密码加密
        password = MD5Util.getMD5(password);
        return !ObjectUtil.isEmpty(user) && user.getPassword().equals(password);
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
    public boolean register(String username, String password, String telephone, String authCode,String sessionId) {
        /*//检验用户输入的验证码是否正确
        String codeInCache = CacheUtil.authCodeCache.get(sessionId);
        if (StrUtil.isEmpty(codeInCache) || !codeInCache.equals(authCode)) {
            throw new ApiException("验证码错误");
        }*/
        //检查是否有相同的用户名
        if(userMapper.selectByUsername(username) != null){
            throw new ApiException("该用户已经存在，请重新输入用户名");
        }

        User user = new User();
        UserUtil.getUser(user,username,password,telephone);//使用User工具初始化user

        //设置注册时间，调用ID工具类生成ID
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());
        user.setId(String.valueOf(iIdGeneratorMap.get(Constants.Ids.SnowFlake).nextId()));
        //调用插入方法
        userMapper.insert(user);
        System.out.println("注册成功");

        return true;//若以上机制都没抛出异常则注册成功
    }

    /**
     * 修改个人信息
     *
     * @param telephone 手机号
     * @param password  新密码密码
     */
    @Override
    public boolean updatePassword(String username,String editedUsername,String password,String editPassword, String telephone) {
        //MD5密码加密
        String md5PassWord = MD5Util.getMD5(password);
        User user = userMapper.selectByUsername(username);

        if(!md5PassWord.equals(user.getPassword())){//如果用户填写的密码与查询出来的密码不相等就不能更改密码
            throw new ApiException("你输入用户名或密码错误");
        }
        UserUtil.getUser(user,username,editPassword,telephone);//使用User工具初始化user
        //更新密码或者手机
        userMapper.updateUserPasswd(username,user.getPassword());
        userMapper.updateTelephone(username,user.getPhone());
        userMapper.updateUsername(username,editedUsername);
        return true;
    }


    /**
     * 根据用户名获取用户
     *
     * @param username 用户名称
     * @return User 用户实体
     */
    @Override
    public User getByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        if (user == null){
            throw new ApiException("没有查询符合要求的用户");
        }
        return user;
    }


    /**
     * 根据用户编号获取用户
     *
     * @param id 用户id
     * @return User 用户实体
     */
    @Override
    public User getById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null){
            throw new ApiException("没有查询符合要求的用户");
        }
        return user;
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
     * 模糊查询
     */
    public List<User> fuzzQuery(String key){
        List<User> userList = userMapper.fuzzQuery(key);
        if (userList == null){
            throw new ApiException("未找到类似的用户");
        }

        return userList;
    }

    //删除用户,RABC
    /**
     * 删除用户
     */

    @Override
    public void deleteUserByUsername(String username){
        if (userMapper.selectByUsername(username) == null){
            throw new ApiException("查无此人");
        }
        userMapper.deleteByUserName(username);
    }


    @Override
    public void deleteUserById(String id) {
        if (userMapper.selectByPrimaryKey(id) == null){
            throw new ApiException("查无此人");
        }
        userMapper.deleteByPrimaryKey(id);
    }
}
