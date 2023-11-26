package com.iweb.mall.portal.service.impl;

import api.CommonResult;
import cn.hutool.core.util.ObjectUtil;
import com.iweb.mall.mapper.OrderitemMapper;
import com.iweb.mall.mapper.OrdersMapper;
import com.iweb.mall.mapper.PayinfoMapper;
import com.iweb.mall.mapper.ShoppingMapper;
import com.iweb.mall.model.*;
import com.iweb.mall.portal.domain.OrderDetails;
import com.iweb.mall.portal.eventBus.events.DoPayEvent;
import com.iweb.mall.portal.service.OrderService;
import com.iweb.mall.portal.stateFlow.IStateHandler;
import com.iweb.mall.portal.util.CacheUtil;
import com.iweb.mall.portal.util.ParameterValidateUtil;
import com.iweb.mall.portal.util.idSupport.IIdGenerator;
import domain.Constants;
import exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
    private ShoppingMapper shoppingMapper;
    private PayinfoMapper payinfoMapper;
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;
    private final ApplicationEventPublisher publisher;
    private IStateHandler stateHandler;


    @Override
    public Orders createOrder(String userId, String shoppingId) {
        String id = String.valueOf(idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        return createOrder(id, userId, shoppingId);
    }

    public Orders createOrder(String orderId, String userId, String shoppingId) {
        Orders orders = new Orders();
        orders.setId(orderId);
        orders.setUserid(userId);
        orders.setShoppingid(shoppingId);
        orders.setPaymenttype(1);
        orders.setStatus(10);
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
        publisher.publishEvent(new DoPayEvent(this, order));
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
    public CommonResult afterPayed(String orderId) {
        Enum<Constants.OrderState> currentState = getOrderStateByCache(orderId);
        return stateHandler.pay(orderId, currentState);
    }

    @Override
    public CommonResult afterDelivered(String orderId) {
        Enum<Constants.OrderState> currentState = getOrderStateByCache(orderId);
        return stateHandler.deliver(orderId, currentState);
    }

    @Override
    public CommonResult afterDone(String orderId) {
        Enum<Constants.OrderState> currentState = getOrderStateByCache(orderId);
        return stateHandler.done(orderId, currentState);
    }

    @Override
    public CommonResult afterClose(String orderId) {
        Enum<Constants.OrderState> currentState = getOrderStateByCache(orderId);
        return stateHandler.close(orderId, currentState);
    }

    @Override
    public CommonResult afterCanceled(String orderId) {
        Enum<Constants.OrderState> currentState = getOrderStateByCache(orderId);
        return stateHandler.cancel(orderId, currentState);
    }

    @Override
    public CommonResult getOrderDetails(String orderId) {
        OrderDetails orderDetails = CacheUtil.orderDetailsCache.get(orderId);
        if (ObjectUtil.isNotEmpty(orderDetails)) {
            return CommonResult.success(orderDetails);
        }
        orderDetails = new OrderDetails();
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        if (ObjectUtil.isEmpty(orders)) {
            throw new ApiException("试图获取不存在的订单");
        }
        orderDetails.setOrders(orders);
        orderDetails.setOrderItems(orderitemMapper.selectByOrdersId(orderId));
        orderDetails.setShopping(shoppingMapper.selectByOrderId(orderId));
        orderDetails.setPayinfo(payinfoMapper.selectByOrderId(orderId));
        CacheUtil.orderDetailsCache.put(orderId, orderDetails);

        return CommonResult.success(orderDetails);
    }

    @Override
    public CommonResult getOrderDetailsByUserId(String uerId) {
        List<Orders> orders = ordersMapper.selectByUserId(uerId);
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(orders)) {
            for (Orders order : orders) {
                String id = order.getId();
                List<Orderitem> orderitemList = orderitemMapper.selectByOrdersId(id);
                Shopping shopping = shoppingMapper.selectByOrderId(id);
                Payinfo payinfo = payinfoMapper.selectByOrderId(id);
                OrderDetails orderDetail = new OrderDetails();
                orderDetail.setOrders(order);
                orderDetail.setOrderItems(orderitemList);
                orderDetail.setShopping(shopping);
                orderDetail.setPayinfo(payinfo);
                orderDetails.add(orderDetail);
                CacheUtil.orderDetailsCache.put(id, orderDetail);
            }
        }

        return CommonResult.success(orderDetails);
    }

    @Override
    public Enum<Constants.OrderState> getOrderStateByCache(String orderId) {
        Enum<Constants.OrderState> currentState = CacheUtil.stateMap.get(orderId);
        if (ObjectUtil.isEmpty(currentState)) {
            Orders order = ordersMapper.selectByPrimaryKey(orderId);
            currentState = Constants.OrderState.getState(order.getStatus());
            CacheUtil.stateMap.put(orderId, currentState);
        }
        return currentState;
    }

    @Override
    public CommonResult selectOrderItemsByProName(String userId, String proName) {
        List<Orderitem> orderitemList = orderitemMapper.selectOrderItemByProName(userId, proName);
        return CommonResult.success(orderitemList);
    }
}
