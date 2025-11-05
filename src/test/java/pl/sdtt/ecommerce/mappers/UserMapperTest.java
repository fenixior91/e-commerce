package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.UserDTO;
import pl.sdtt.ecommerce.enums.UserRole;
import pl.sdtt.ecommerce.model.Cart;
import pl.sdtt.ecommerce.model.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    void testToEntity() {
        //given
        Long cartId = 1L;
        String username = "username";
        String password = "password";
        String email = "email@example.com";
        UserRole role = UserRole.ADMIN;

        UserDTO userDTO = UserDTO.builder()
                .cartId(cartId)
                .username(username)
                .password(password)
                .email(email)
                .role(role)
                .build();

        //when
        User user = userMapper.toEntity(userDTO);

        //then
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNull();
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getRole()).isEqualTo(role);
        assertThat(user.getCart()).isNotNull();
        assertThat(user.getCart().getId()).isEqualTo(cartId);

        assertThat(user.getVersion()).isEqualTo(0);
        assertThat(user.getAddresses()).isNull();
        assertThat(user.getOrders()).isNull();
        assertThat(user.getReviews()).isNull();
        assertThat(user.getCreatedAt()).isNull();
        assertThat(user.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long cartId = 1L;
        String username = "username";
        String password = "password";
        String email = "email@example.com";
        UserRole role = UserRole.ADMIN;

        Cart cart = Cart.builder().id(cartId).build();
        User user = User.builder()
                .cart(cart)
                .username(username)
                .password(password)
                .email(email)
                .role(role)
                .build();

        //when
        UserDTO userDTO = userMapper.toDTO(user);

        //then
        assertThat(userDTO).isNotNull();
        assertThat(userDTO.id()).isNull();
        assertThat(userDTO.username()).isEqualTo(username);
        assertThat(userDTO.password()).isEqualTo(password);
        assertThat(userDTO.email()).isEqualTo(email);
        assertThat(userDTO.role()).isEqualTo(role);
    }

    @Test
    void testMapCartIdToCart() {
        Cart cart = userMapper.mapCartIdToCart(null);
        assertThat(cart).isNull();
    }
}
