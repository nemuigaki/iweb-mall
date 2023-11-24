package com.iweb.mall.portal.util.idSupport;

import com.iweb.mall.portal.util.idSupport.policy.RandomNumeric;
import com.iweb.mall.portal.util.idSupport.policy.ShortCode;
import com.iweb.mall.portal.util.idSupport.policy.SnowFlake;
import domain.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description Id 策略模式上下文配置
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal.util.idSupport
 */
@Configuration
public class IdContext {
    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric) {
        HashMap<Constants.Ids, IIdGenerator> map = new HashMap<>();
        map.put(Constants.Ids.SnowFlake, snowFlake);
        map.put(Constants.Ids.ShortCode, shortCode);
        map.put(Constants.Ids.RandomNumeric, randomNumeric);
        return map;
    }

}