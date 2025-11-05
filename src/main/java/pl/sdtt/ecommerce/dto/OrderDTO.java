package pl.sdtt.ecommerce.dto;

import lombok.Builder;
import pl.sdtt.ecommerce.enums.OrderStatus;

import java.math.BigDecimal;

@Builder
public record OrderDTO(
        Long id,
        Long userId,
        Long addressId,
        BigDecimal totalPrice,
        OrderStatus status) {
}
