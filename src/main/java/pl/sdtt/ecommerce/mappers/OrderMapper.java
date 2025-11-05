package pl.sdtt.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.sdtt.ecommerce.dto.OrderDTO;
import pl.sdtt.ecommerce.model.Address;
import pl.sdtt.ecommerce.model.Order;
import pl.sdtt.ecommerce.model.User;

@Mapper
public interface OrderMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    @Mapping(target = "address", source = "addressId", qualifiedByName = "mapAddressIdToAddress")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Order toEntity(OrderDTO orderDTO);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "addressId", source = "address.id")
    OrderDTO toDTO(Order order);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(Long userId) {
        if (userId == null) return null;
        User user = new User();
        user.setId(userId);
        return user;
    }

    @Named("mapAddressIdToAddress")
    default Address mapAddressIdToAddress(Long addressId) {
        if (addressId == null) return null;
        Address address = new Address();
        address.setId(addressId);
        return address;
    }
}
