package pl.sdtt.ecommerce.dto;

import lombok.Builder;

@Builder
public record AddressDTO(
        Long id,
        Long userId,
        String street,
        String city,
        String zip,
        String country
) {
}
