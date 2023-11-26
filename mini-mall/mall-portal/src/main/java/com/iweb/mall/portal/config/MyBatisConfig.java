package com.iweb.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description MyBatis相关配置
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.portal.config
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.iweb.mall.mapper", "com.iweb.mall.portal.repository"})
public class MyBatisConfig {
}