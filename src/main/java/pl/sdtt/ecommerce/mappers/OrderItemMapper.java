package pl.sdtt.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.sdtt.ecommerce.dto.OrderItemDTO;
import pl.sdtt.ecommerce.model.Order;
import pl.sdtt.ecommerce.model.OrderItem;
import pl.sdtt.ecommerce.model.Product;

@Mapper
public interface OrderItemMapper {

    @Mapping(target = "order", source = "orderId", qualifiedByName = "mapOrderIdToOrder")
    @Mapping(target = "product", source = "productId", qualifiedByName = "mapProductIdToProduct")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OrderItem toEntity(OrderItemDTO orderItemDTO);

    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "productId", source = "product.id")
    OrderItemDTO toDTO(OrderItem orderItem);

    @Named("mapOrderIdToOrder")
    default Order mapOrderIdToOrder(Long orderId) {
        if (orderId == null) return null;
        Order order = new Order();
        order.setId(orderId);
        return order;
    }

    @Named("mapProductIdToProduct")
    default Product mapProductIdToProduct(Long productId) {
        if (productId == null) return null;
        Product product = new Product();
        product.setId(productId);
        return product;
    }
}


