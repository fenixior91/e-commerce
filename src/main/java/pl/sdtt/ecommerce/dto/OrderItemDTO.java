package pl.sdtt.ecommerce.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderItemDTO(
        Long id,
        Long orderId,
        Long productId,
        int quantity,
        BigDecimal priceAtPurchase
) {
}
