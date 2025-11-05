package pl.sdtt.ecommerce.dto;

public record AddressDTO(
        Long id,
        Long userId,
        String street,
        String city,
        String zip,
        String country
) {
}
