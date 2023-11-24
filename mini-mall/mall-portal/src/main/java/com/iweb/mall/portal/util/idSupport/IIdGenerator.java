package com.iweb.mall.portal.util.idSupport;

/**
 * @Description id生成接口
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal.util.idSupport
 */
public interface IIdGenerator {
    /**
     * 生成id的实现:
     * 1.雪花算法
     * 2.日期算法
     */
    long nextId();
}
