package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.OrderDTO;
import pl.sdtt.ecommerce.enums.OrderStatus;
import pl.sdtt.ecommerce.model.Address;
import pl.sdtt.ecommerce.model.Order;
import pl.sdtt.ecommerce.model.User;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderMapperTest {

    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Test
    void testToEntity() {
        //given
        Long userId = 1L;
        Long addressId = 2L;
        BigDecimal totalPrice = new BigDecimal("21.37");
        OrderStatus status = OrderStatus.SHIPPED;

        OrderDTO orderDTO = OrderDTO.builder()
                .userId(userId)
                .addressId(addressId)
                .totalPrice(totalPrice)
                .status(status)
                .build();

        //when
        Order order = orderMapper.toEntity(orderDTO);

        //then
        assertThat(order).isNotNull();
        assertThat(order.getId()).isNull();
        assertThat(order.getTotalPrice()).isEqualTo(totalPrice);
        assertThat(order.getStatus()).isEqualTo(status);
        assertThat(order.getUser()).isNotNull();
        assertThat(order.getUser().getId()).isEqualTo(userId);
        assertThat(order.getAddress()).isNotNull();
        assertThat(order.getAddress().getId()).isEqualTo(addressId);

        assertThat(order.getVersion()).isEqualTo(0);
        assertThat(order.getOrderItems()).isNull();
        assertThat(order.getCreatedAt()).isNull();
        assertThat(order.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long userId = 1L;
        Long addressId = 2L;
        BigDecimal totalPrice = new BigDecimal("21.37");
        OrderStatus status = OrderStatus.SHIPPED;

        User user = User.builder().id(userId).build();
        Address address = Address.builder().id(addressId).build();

        Order order = Order.builder()
                .user(user)
                .address(address)
                .totalPrice(totalPrice)
                .status(status)
                .build();

        //when
        OrderDTO orderDTO = orderMapper.toDTO(order);

        //then
        assertThat(orderDTO).isNotNull();
        assertThat(orderDTO.id()).isNull();
        assertThat(orderDTO.totalPrice()).isEqualTo(totalPrice);
        assertThat(orderDTO.status()).isEqualTo(status);
        assertThat(orderDTO.userId()).isEqualTo(userId);
        assertThat(orderDTO.addressId()).isEqualTo(addressId);
    }

    @Test
    void testMapUserIdToUser() {
        User user = orderMapper.mapUserIdToUser(null);
        assertThat(user).isNull();
    }

    @Test
    void testMapAddressIdToAddress() {
        Address address = orderMapper.mapAddressIdToAddress(null);
        assertThat(address).isNull();
    }
}
