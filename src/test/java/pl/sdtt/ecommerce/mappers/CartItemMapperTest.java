package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.CartItemDTO;
import pl.sdtt.ecommerce.model.Cart;
import pl.sdtt.ecommerce.model.CartItem;
import pl.sdtt.ecommerce.model.Product;

import static org.assertj.core.api.Assertions.assertThat;

public class CartItemMapperTest {

    private final CartItemMapper cartItemMapper = Mappers.getMapper(CartItemMapper.class);

    @Test
    void testToEntity() {
        //given
        Long cartId = 1L;
        Long productId = 2L;
        int quantity = 3;

        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .cartId(cartId)
                .productId(productId)
                .quantity(quantity)
                .build();

        //when
        CartItem cartItem = cartItemMapper.toEntity(cartItemDTO);

        //then
        assertThat(cartItem).isNotNull();
        assertThat(cartItem.getId()).isNull();
        assertThat(cartItem.getQuantity()).isEqualTo(quantity);
        assertThat(cartItem.getCart()).isNotNull();
        assertThat(cartItem.getCart().getId()).isEqualTo(cartId);
        assertThat(cartItem.getProduct()).isNotNull();
        assertThat(cartItem.getProduct().getId()).isEqualTo(productId);

        assertThat(cartItem.getVersion()).isEqualTo(0);
        assertThat(cartItem.getCreatedAt()).isNull();
        assertThat(cartItem.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long cartId = 1L;
        Long productId = 2L;
        int quantity = 3;

        Cart cart = Cart.builder().id(cartId).build();
        Product product = Product.builder().id(productId).build();
        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .product(product)
                .quantity(quantity)
                .build();

        //when
        CartItemDTO cartItemDTO = cartItemMapper.toDTO(cartItem);

        //then
        assertThat(cartItemDTO).isNotNull();
        assertThat(cartItemDTO.id()).isNull();
        assertThat(cartItemDTO.quantity()).isEqualTo(quantity);
        assertThat(cartItemDTO.cartId()).isEqualTo(cartId);
        assertThat(cartItemDTO.productId()).isEqualTo(productId);
    }

    @Test
    void testMapCartIdToCart() {
        Cart cart = cartItemMapper.mapCartIdToCart(null);
        assertThat(cart).isNull();
    }

    @Test
    void testMapProductIdToProduct() {
        Product product = cartItemMapper.mapProductIdToProduct(null);
        assertThat(product).isNull();
    }
}
