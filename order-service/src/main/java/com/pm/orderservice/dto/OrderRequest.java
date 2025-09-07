package com.pm.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderId, String skuCode, Integer quantity, BigDecimal price, Long userId) {
}
