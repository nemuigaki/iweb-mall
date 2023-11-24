package com.iweb.mall.portal.domain;

import com.iweb.mall.model.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal.domain
 */
@Data
public class OrderDetails implements Serializable {

    private Orders orders;

    private List<Orderitem> orderItems;

    private Shopping shopping;

    private Payinfo payinfo;
}
