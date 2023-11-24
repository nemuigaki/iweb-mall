package com.iweb.mall.portal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.iweb.mall.mapper.OrderitemMapper;
import com.iweb.mall.mapper.OrdersMapper;
import com.iweb.mall.model.Orderitem;
import com.iweb.mall.model.Orders;
import com.iweb.mall.model.Product;
import com.iweb.mall.portal.domain.OrderDetails;
import com.iweb.mall.portal.service.OrderService;
import com.iweb.mall.portal.util.CacheUtil;
import com.iweb.mall.portal.util.ParameterValidateUtil;
import com.iweb.mall.portal.util.idSupport.IIdGenerator;
import domain.Constants;
import exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package com.iweb.mall.portal.service.impl
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrdersMapper ordersMapper;
    private OrderitemMapper orderitemMapper;
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public Orders createOrder(String userId, String shoppingId) {
        Orders orders = new Orders();
        String id = String.valueOf(idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        orders.setId(id);
        orders.setUserid(userId);
        orders.setShoppingid(shoppingId);
        orders.setPaymenttype(1);
        orders.setPostage(6);
        Date date = new Date();
        orders.setCreatetime(date);
        orders.setUpdatetime(date);

        ordersMapper.insert(orders);
        return orders;
    }

    @Override
    public Orderitem createOrderItem(String orderId, String userId, Product product, int quantity) {
        Orderitem orderitem = new Orderitem();
        orderitem.setId(String.valueOf(idGeneratorMap.get(Constants.Ids.SnowFlake).nextId()));
        orderitem.setOrderid(orderId);
        orderitem.setUserid(userId);
        if (ObjectUtil.isEmpty(product)) {
            throw new ApiException("该商品不存在[id=" + product.getId() + "]");
        }
        orderitem.setProid(product.getId());
        orderitem.setProname(product.getName());
        BigDecimal price = product.getPrice();
        orderitem.setCurrentunitprice(price);
        orderitem.setProimage(product.getMainimage());
        orderitem.setTotalprice(price.multiply(BigDecimal.valueOf(quantity)));
        orderitemMapper.insert(orderitem);
        return orderitem;
    }

    @Override
    public Orderitem createOrderItem(Orderitem orderitem, Product product) {
        return createOrderItem(orderitem.getId(), orderitem.getUserid(), product, orderitem.getQuantity());
    }

    @Override
    public void batchStoreOrderItem() {

    }

    @Override
    public void doShopping(OrderDetails orderDetails) {
        // 检查订单信息
        Orders order = orderDetails.getOrders();
        String orderId = order.getId();
        List<Orderitem> orderitemList = orderDetails.getOrderItems();
        if (!ParameterValidateUtil.validate(order, orderitemList)) {
            throw new ApiException("订单[id=" + orderId + "]信息有误, 订单不存在或子订单为空");
        }
        // 组合订单信息
        Optional<BigDecimal> total = orderitemList.stream().map(Orderitem::getTotalprice).reduce(BigDecimal::add);
        order.setPayment(total.orElseGet(() -> BigDecimal.valueOf(0)));

        // 缓存订单信息
        CacheUtil.orderDetailsCache.put(orderId, orderDetails);

    }

    @Override
    public void cancelOrder() {

    }

    @Override
    public void cancelOrderItem() {

    }

    @Override
    public void updatePayment() {

    }

    @Override
    public void afterPayed(String orderId) {
        // TODO 更新订单状态
    }
}
