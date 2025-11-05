package pl.sdtt.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.sdtt.ecommerce.dto.CartItemDTO;
import pl.sdtt.ecommerce.model.Cart;
import pl.sdtt.ecommerce.model.CartItem;
import pl.sdtt.ecommerce.model.Product;

@Mapper
public interface CartItemMapper {

    @Mapping(target = "cart", source = "cartId", qualifiedByName = "mapCartIdToCart")
    @Mapping(target = "product", source = "productId", qualifiedByName = "mapProductIdToProduct")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CartItem toEntity(CartItemDTO cartItemDTO);

    @Mapping(target = "cartId", source = "cart.id")
    @Mapping(target = "productId", source = "product.id")
    CartItemDTO toDTO(CartItem cartItem);

    @Named("mapCartIdToCart")
    default Cart mapCartIdToCart(Long cartId) {
        if (cartId == null) return null;
        Cart cart = new Cart();
        cart.setId(cartId);
        return cart;
    }

    @Named("mapProductIdToProduct")
    default Product mapProductIdToProduct(Long productId) {
        if (productId == null) return null;
        Product product = new Product();
        product.setId(productId);
        return product;
    }
}
