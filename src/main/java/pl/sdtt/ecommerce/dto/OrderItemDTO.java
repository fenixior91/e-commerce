package pl.sdtt.ecommerce.dto;

import java.math.BigDecimal;

public record OrderItemDTO(
        Long id,
        Long orderId,
        Long productId,
        int quantity,
        BigDecimal priceAtPurchase
) {
}
