package pl.sdtt.ecommerce.dto;

import pl.sdtt.ecommerce.enums.UserRole;

public record UserDTO(
        Long id,
        Long cartId,
        String username,
        String password,
        String email,
        UserRole role
) {
}
