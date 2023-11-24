package com.iweb.mall.portal.util;

import cn.hutool.core.util.ObjectUtil;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.portal.util
 */
public class ParameterValidateUtil {
    private ParameterValidateUtil() {}

    /**
     * 可变参数验证工具
     * @param parameters 需要验证的参数
     * @return 都不为空返回true 否则返回false
     */
    public static boolean validate(Object... parameters) {
        for (Object parameter : parameters) {
            if (ObjectUtil.isEmpty(parameter)) {
                return false;
            }
        }

        return true;
    }
}
