package com.iweb.mall.portal.service;

import com.iweb.mall.model.User;
import com.iweb.mall.portal.domain.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

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
    User getByUsername(String username);

    boolean login(String username, String password, String code, String sessionId);

    /**
     * 根据会员编号获取会员
     */
    User getById(Long id);

    /**
     * 用户注册
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * 生成验证码
     */
    String generateAuthCode(HttpServletResponse response);

    /**
     * 修改密码
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

}
