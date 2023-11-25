package com.iweb.mall.portal.service;

import api.CommonResult;
import com.iweb.mall.model.User;
import com.iweb.mall.portal.domain.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.portal.service
 */
public interface UserService {
    /**
     * 根据用户名获取会员
     */
    CommonResult getByUsername(String username);

    CommonResult login(String username, String password, String code, String sessionId);

    /**
     * 根据会员编号获取会员
     */
    CommonResult getById(String id);

    /**
     * 用户注册
     */
    @Transactional
    CommonResult register(String username, String password, String telephone, String authCode,String sessionId);

    /**
     * 生成验证码
     */
    String generateAuthCode(HttpServletResponse response);

    /**
     * 修改密码
     */
    @Transactional
    CommonResult updatePassword(String username, String editedUsername,String password,String editPassword, String telephone);

    /**
     * 删除用户(通过用户名或者名字删除)
     */
    @Transactional
    CommonResult deleteUserByUsername(String name);

    @Transactional
    CommonResult deleteUserById(String id);

    @Transactional
    CommonResult fuzzQuery(String key);
}
