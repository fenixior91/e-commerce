package pl.sdtt.ecommerce.dto;

public record CartItemDTO(
        Long id,
        Long cartId,
        Long productId,
        int quantity
) {
}
