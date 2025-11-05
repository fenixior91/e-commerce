package pl.sdtt.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.sdtt.ecommerce.dto.CartDTO;
import pl.sdtt.ecommerce.model.Cart;
import pl.sdtt.ecommerce.model.User;

@Mapper
public interface CartMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "cartItems", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Cart toEntity(CartDTO cartDTO);

    @Mapping(target = "userId", source = "user.id")
    CartDTO toDTO(Cart cart);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(Long userId) {
        if (userId == null) return null;
        User user = new User();
        user.setId(userId);
        return user;
    }
}
