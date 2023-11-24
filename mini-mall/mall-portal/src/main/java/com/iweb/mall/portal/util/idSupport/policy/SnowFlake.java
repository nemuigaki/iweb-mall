package com.iweb.mall.portal.util.idSupport.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.iweb.mall.portal.util.idSupport.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description 基于huTool的雪花算法
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal.util.idSupport.policy
 */
@Component
public class SnowFlake implements IIdGenerator {
    private Snowflake snowFlake;

    @PostConstruct
    public void init() {
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

        workerId = workerId >> 16 & 31;

        long dataCenterId = 1L;
        snowFlake = IdUtil.getSnowflake(workerId, dataCenterId);
    }

    @Override
    public long nextId() {
        return snowFlake.nextId();
    }
}
