package com.pm.orderservice.controller;

import com.pm.orderservice.dto.OrderRequest;
import com.pm.orderservice.model.Order;
import com.pm.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        Order savedOrder = orderService.placeOrder(orderRequest);
        return ResponseEntity.ok("✅ Order is placed successfully with ID: " + savedOrder.getOrderId());
    }
}
