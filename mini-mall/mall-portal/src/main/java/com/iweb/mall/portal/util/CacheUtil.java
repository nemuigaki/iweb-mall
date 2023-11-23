package com.iweb.mall.portal.util;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.portal.util
 */
public class CacheUtil {
    private CacheUtil() {
    }

    public static TimedCache<String, String> authCodeCache = new TimedCache<>(DateUnit.SECOND.getMillis() * 60);
}
