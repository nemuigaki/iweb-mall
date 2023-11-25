package com.iweb.mall.portal.util;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;
import com.iweb.mall.portal.domain.OrderDetails;
import domain.Constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;

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

    public static TimedCache<String, OrderDetails> orderDetailsCache = new TimedCache<>(DateUnit.DAY.getMillis() * 5);

    public static Map<String, SynchronousQueue<Map<Constants.PaymentUrl, String>>> payMap = new ConcurrentHashMap<>();

    public static TimedCache<String, Enum<Constants.OrderState>> stateMap = new TimedCache<>(DateUnit.MINUTE.getMillis() * 30);

}
