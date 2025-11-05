package pl.sdtt.ecommerce.dto;

import lombok.Builder;
import pl.sdtt.ecommerce.enums.UserRole;

@Builder
public record UserDTO(
        Long id,
        Long cartId,
        String username,
        String password,
        String email,
        UserRole role
) {
}
