package pl.sdtt.ecommerce.dto;

import pl.sdtt.ecommerce.enums.OrderStatus;

import java.math.BigDecimal;

public record OrderDTO(
        Long id,
        Long userId,
        Long addressId,
        BigDecimal totalPrice,
        OrderStatus status) {
}
