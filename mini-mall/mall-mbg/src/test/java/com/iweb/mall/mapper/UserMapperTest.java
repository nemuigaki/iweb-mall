package com.iweb.mall.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.mapper
 */
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void selectByUsername() {
        System.out.println(userMapper.selectByUsername("test"));
    }
}