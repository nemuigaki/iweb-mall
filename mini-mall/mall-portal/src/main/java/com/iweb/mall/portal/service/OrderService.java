package com.iweb.mall.portal.service;

import com.iweb.mall.model.*;
import com.iweb.mall.portal.domain.OrderDetails;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal.service
 */
public interface OrderService {
    Orders createOrder(String userId, String shoppingId);

    Orders createOrder(String orderId, String userId, String shoppingId);

    Orderitem createOrderItem(String orderId, String userId, Product product, int quantity);

    Orderitem createOrderItem(Orderitem orderitem, Product product);

    void batchStoreOrderItem();

    void doShopping(OrderDetails orderDetails);

    void cancelOrder();

    void cancelOrderItem();

    void updatePayment();

    void afterPayed(String orderId);

    OrderDetails getOrderDetails(String orderId);
}
