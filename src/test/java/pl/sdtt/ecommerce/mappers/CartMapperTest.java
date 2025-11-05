package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.CartDTO;
import pl.sdtt.ecommerce.model.Cart;
import pl.sdtt.ecommerce.model.User;

import static org.assertj.core.api.Assertions.assertThat;

public class CartMapperTest {

    private final CartMapper cartMapper = Mappers.getMapper(CartMapper.class);

    @Test
    void testToEntity() {
        //given
        Long userId = 1L;

        CartDTO cartDTO = CartDTO.builder()
                .userId(userId)
                .build();

        //when
        Cart cart = cartMapper.toEntity(cartDTO);

        //then
        assertThat(cart).isNotNull();
        assertThat(cart.getId()).isNull();
        assertThat(cart.getUser()).isNotNull();
        assertThat(cart.getUser().getId()).isEqualTo(userId);

        assertThat(cart.getVersion()).isEqualTo(0);
        assertThat(cart.getCartItems()).isNull();
        assertThat(cart.getCreatedAt()).isNull();
        assertThat(cart.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long userId = 1L;

        User user = User.builder().id(userId).build();
        Cart cart = Cart.builder()
                .user(user)
                .build();

        //when
        CartDTO cartDTO = cartMapper.toDTO(cart);

        //then
        assertThat(cartDTO).isNotNull();
        assertThat(cartDTO.id()).isNull();
        assertThat(cartDTO.userId()).isEqualTo(userId);
    }

    @Test
    void testMapUserIdToUser() {
        User user = cartMapper.mapUserIdToUser(null);
        assertThat(user).isNull();
    }
}
