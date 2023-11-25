package com.iweb.mall.portal.service;

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
    User getByUsername(String username);

    boolean login(String username, String password, String code, String sessionId);

    /**
     * 根据会员编号获取会员
     */
    User getById(String id);

    /**
     * 用户注册
     */
    @Transactional
    boolean register(String username, String password, String telephone, String authCode,String sessionId);

    /**
     * 生成验证码
     */
    String generateAuthCode(HttpServletResponse response);

    /**
     * 修改密码
     */
    @Transactional
    boolean updatePassword(String username, String editedUsername,String password,String editPassword, String telephone);

    /**
     * 删除用户(通过用户名或者名字删除)
     */
    @Transactional
    void deleteUserByUsername(String name);

    @Transactional
    void deleteUserById(String id);

    @Transactional
    List<User> fuzzQuery(String key);
}
