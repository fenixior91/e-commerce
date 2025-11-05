package pl.sdtt.ecommerce.dto;

import lombok.Builder;

@Builder
public record CategoryDTO(
        Long id,
        String name,
        String description
) {

}
