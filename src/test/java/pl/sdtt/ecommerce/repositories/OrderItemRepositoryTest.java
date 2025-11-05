package pl.sdtt.ecommerce.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.sdtt.ecommerce.model.OrderItem;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class OrderItemRepositoryTest {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    void testFindAll() {
        Set<OrderItem> orderItems = new HashSet<>(orderItemRepository.findAll());

        assertThat(orderItems).isNotEmpty();
        assertThat(orderItems).hasSize(31);
    }
}
