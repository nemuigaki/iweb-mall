package com.iweb.mall.portal.eventBus.listeners;

import com.iweb.mall.mapper.ProductMapper;
import com.iweb.mall.mapper.ShoppingMapper;
import com.iweb.mall.model.*;
import com.iweb.mall.portal.domain.OrderDetails;
import com.iweb.mall.portal.eventBus.events.ShoppingEvent;
import com.iweb.mall.portal.service.OrderService;
import com.iweb.mall.portal.service.PaymentService;
import com.iweb.mall.portal.stateFlow.event.CreateState;
import com.iweb.mall.portal.util.CacheUtil;
import com.iweb.mall.portal.util.idSupport.IIdGenerator;
import domain.Constants;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 下单事件监听器
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal.eventBus.listeners
 */
@Component
@AllArgsConstructor
public class ShoppingListener {
    private OrderService orderService;
    private PaymentService paymentService;
    private ShoppingMapper shoppingMapper;
    private ProductMapper productMapper;
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Async
    @EventListener(ShoppingEvent.class)
    @Transactional
    public void doShopping(ShoppingEvent shoppingEvent){
        // 获取事件资源
        List<Cart> cartList = shoppingEvent.getCartList();
        Shopping shopping = shoppingEvent.getShopping();

        // 生成/获取ids
        String shoppingId = String.valueOf(idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        String userId = shopping.getUserid();
        String orderId = shopping.getOrderid();

        // 创建订单和子订单
        Orders order = orderService.createOrder(orderId, userId, shoppingId);
        List<Orderitem> orderitemList = new ArrayList<>();
        cartList.forEach(item->{
            Product product = productMapper.selectByPrimaryKey(item.getProid());
            Orderitem orderItem = orderService.createOrderItem(orderId, userId, product, item.getQuantity());
            orderitemList.add(orderItem);
        });

        // 将订单状态添加到管理缓存中
        CacheUtil.stateMap.put(orderId, Constants.OrderState.getState(order.getStatus()));

        // 创建支付信息
        Payinfo payInfo = paymentService.createPayInfo(order);

        // 填充购买信息数据
        shopping.setId(shoppingId);
        shopping.setOrderid(orderId);

        // 入库收货信息
        shoppingMapper.insert(shopping);

        // 构建完整的订单信息
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrders(order);
        orderDetails.setOrderItems(orderitemList);
        orderDetails.setShopping(shopping);
        orderDetails.setPayinfo(payInfo);

        orderService.doShopping(orderDetails);
    }
}
