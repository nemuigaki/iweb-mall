package com.iweb.mall.portal.service;

import api.CommonResult;
import com.iweb.mall.model.Orderitem;
import com.iweb.mall.model.Orders;
import com.iweb.mall.model.Product;
import com.iweb.mall.portal.domain.OrderDetails;
import domain.Constants;

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

    CommonResult afterPayed(String orderId);

    CommonResult afterDelivered(String orderId);

    CommonResult afterDone(String orderId);

    CommonResult afterClose(String orderId);

    CommonResult afterCanceled(String orderId);

    CommonResult getOrderDetails(String orderId);

    CommonResult getOrderDetailsByUserId(String userId);

    Enum<Constants.OrderState> getOrderStateByCache(String orderId);

    CommonResult selectOrderItemsByProName(String userId, String proIName);
}
