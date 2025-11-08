package pl.sdtt.ecommerce.dto.product;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record ProductResponseDTO(
        Long id,
        Long categoryId,
        String name,
        String description,
        BigDecimal price,
        int stockQuantity,
        String imageUrl,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
