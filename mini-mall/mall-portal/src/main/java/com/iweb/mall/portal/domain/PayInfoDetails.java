package com.iweb.mall.portal.domain;

import com.iweb.mall.model.Payinfo;
import lombok.Data;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.domain
 */
@Data
public class PayInfoDetails {
    private Payinfo payinfo;
    private Integer payment;
}
