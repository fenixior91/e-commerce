package pl.sdtt.ecommerce.dto.product;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponseDTO(
        Long id,
        Long categoryId,
        String name,
        String description,
        BigDecimal price,
        int stockQuantity,
        String imageUrl) {
}
