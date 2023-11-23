package com.iweb.mall.portal;

import com.iweb.mall.mapper.UserMapper;
import com.iweb.mall.portal.service.UserService;
import com.iweb.mall.portal.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectByUsername() {
        System.out.println("test");
        System.out.println("userService.getByUsername(\"test\") = " + userMapper.selectByUsername("test"));
    }

    @Test
    public void jslfjTest() {

    }
}
