package com.iweb.mall.portal.util.idSupport.policy;

import com.iweb.mall.portal.util.idSupport.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @Description 基于随机数工具生成11位数据，不保证全局唯一性
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal.util.idSupport.policy
 */
@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
