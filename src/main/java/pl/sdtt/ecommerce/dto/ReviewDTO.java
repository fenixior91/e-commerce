package pl.sdtt.ecommerce.dto;

public record ReviewDTO(
        Long id,
        Long userId,
        Long productId,
        int rating,
        String comment) {
}
