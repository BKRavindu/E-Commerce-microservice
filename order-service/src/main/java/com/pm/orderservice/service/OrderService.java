package com.pm.orderservice.service;

import com.pm.orderservice.client.InventoryClient;
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
    private final InventoryClient inventoryClient;

    public Order placeOrder(OrderRequest orderRequest) {

        boolean isProductInStock=inventoryClient.isInStock(orderRequest.skuCode(),orderRequest.quantity());

        if(isProductInStock){
            Order order = new Order();
            order.setOrderId(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            order.setPrice(orderRequest.price());
            return orderRepository.save(order);
        }else{
            throw new RuntimeException("Product with "+ orderRequest.skuCode() +" is not in stock");
        }
    }
}
