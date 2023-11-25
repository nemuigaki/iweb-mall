package com.iweb.mall.portal;

import com.iweb.mall.mapper.OrderitemMapper;
import com.iweb.mall.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal
 */
@SpringBootTest
public class OrdersMapperTest {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderitemMapper orderitemMapper;
    @Test
    public void queryOrdersTest() {
        System.out.println(ordersMapper.selectByUserId("6129812"));
        System.out.println(ordersMapper.selectByPrimaryKey("1"));
    }

    @Test
    public void queryOrderItemTest() {
        System.out.println(orderitemMapper.selectByPrimaryKey("1"));
        System.out.println(orderitemMapper.selectByOrdersId("1"));
    }
}
