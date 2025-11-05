package pl.sdtt.ecommerce.dto;

import lombok.Builder;

@Builder
public record CartDTO(
        Long id,
        Long userId
) {
}
