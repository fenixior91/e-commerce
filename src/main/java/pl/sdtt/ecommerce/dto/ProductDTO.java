package pl.sdtt.ecommerce.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDTO(
        Long id,
        Long categoryId,
        String name,
        String description,
        BigDecimal price,
        int stockQuantity,
        String imageUrl) {
}
