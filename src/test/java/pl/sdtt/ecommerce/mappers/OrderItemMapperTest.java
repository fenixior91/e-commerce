package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.OrderItemDTO;
import pl.sdtt.ecommerce.model.Order;
import pl.sdtt.ecommerce.model.OrderItem;
import pl.sdtt.ecommerce.model.Product;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemMapperTest {

    private final OrderItemMapper orderItemMapper = Mappers.getMapper(OrderItemMapper.class);

    @Test
    void testToEntity() {
        //given
        Long orderId = 1L;
        Long productId = 1L;
        int quantity = 4;
        BigDecimal priceAtPurchase = new BigDecimal("21.37");

        OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                .orderId(orderId)
                .productId(productId)
                .quantity(quantity)
                .priceAtPurchase(priceAtPurchase)
                .build();

        //when
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);

        //then
        assertThat(orderItem).isNotNull();
        assertThat(orderItem.getId()).isNull();
        assertThat(orderItem.getOrder()).isNotNull();
        assertThat(orderItem.getQuantity()).isEqualTo(quantity);
        assertThat(orderItem.getPriceAtPurchase()).isEqualTo(priceAtPurchase);
        assertThat(orderItem.getOrder().getId()).isEqualTo(orderId);
        assertThat(orderItem.getProduct()).isNotNull();
        assertThat(orderItem.getProduct().getId()).isEqualTo(productId);

        assertThat(orderItem.getVersion()).isEqualTo(0);
        assertThat(orderItem.getCreatedAt()).isNull();
        assertThat(orderItem.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long orderId = 1L;
        Long productId = 2L;
        int quantity = 4;
        BigDecimal priceAtPurchase = new BigDecimal("21.37");

        Order order = Order.builder().id(orderId).build();
        Product product = Product.builder().id(productId).build();

        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .product(product)
                .quantity(quantity)
                .priceAtPurchase(priceAtPurchase)
                .build();

        //when
        OrderItemDTO orderItemDTO = orderItemMapper.toDTO(orderItem);

        //then
        assertThat(orderItemDTO).isNotNull();
        assertThat(orderItemDTO.id()).isNull();
        assertThat(orderItemDTO.quantity()).isEqualTo(quantity);
        assertThat(orderItemDTO.priceAtPurchase()).isEqualTo(priceAtPurchase);
        assertThat(orderItemDTO.orderId()).isEqualTo(orderId);
        assertThat(orderItemDTO.productId()).isEqualTo(productId);
    }

    @Test
    void testMapOrderIdToOrder() {
        Order order = orderItemMapper.mapOrderIdToOrder(null);
        assertThat(order).isNull();
    }

    @Test
    void testMapProductIdToProduct() {
        Product product = orderItemMapper.mapProductIdToProduct(null);
        assertThat(product).isNull();
    }
}
