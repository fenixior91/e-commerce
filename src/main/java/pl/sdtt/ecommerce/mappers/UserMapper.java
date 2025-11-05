package pl.sdtt.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.sdtt.ecommerce.dto.UserDTO;
import pl.sdtt.ecommerce.model.Cart;
import pl.sdtt.ecommerce.model.User;

@Mapper
public interface UserMapper {

    @Mapping(target = "cart", source = "cartId", qualifiedByName = "mapCartIdToCart")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserDTO userDTO);

    @Mapping(target = "cartId", source = "cart.id")
    UserDTO toDTO(User user);

    @Named("mapCartIdToCart")
    default Cart mapCartIdToCart(Long cartId) {
        if (cartId == null) return null;
        Cart cart = new Cart();
        cart.setId(cartId);
        return cart;
    }

}
