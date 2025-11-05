package pl.sdtt.ecommerce.dto;

import lombok.Builder;

@Builder
public record ReviewDTO(
        Long id,
        Long userId,
        Long productId,
        int rating,
        String comment) {
}
