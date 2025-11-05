package pl.sdtt.ecommerce.dto;

import lombok.Builder;

@Builder
public record CartItemDTO(
        Long id,
        Long cartId,
        Long productId,
        int quantity
) {
}
