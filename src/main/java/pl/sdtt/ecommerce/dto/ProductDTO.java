package pl.sdtt.ecommerce.dto;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        Long categoryId,
        String name,
        String description,
        BigDecimal price,
        int stockQuantity,
        String imageUrl) {
}
