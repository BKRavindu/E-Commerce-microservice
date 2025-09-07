package com.pm.orderservice.service;

import com.pm.orderservice.dto.OrderRequest;
import com.pm.orderservice.model.Order;
import com.pm.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order placeOrder(OrderRequest orderRequest) {
        // Convert DTO to entity
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString()); // Generate unique orderId
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        order.setPrice(orderRequest.price());

        // Save order in DB
        return orderRepository.save(order);
    }
}
