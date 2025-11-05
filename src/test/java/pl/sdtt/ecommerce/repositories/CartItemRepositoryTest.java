package pl.sdtt.ecommerce.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.sdtt.ecommerce.model.CartItem;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class CartItemRepositoryTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Test
    void testFindAll() {
        Set<CartItem> cartItems = new HashSet<>(cartItemRepository.findAll());

        assertThat(cartItems).isNotEmpty();
        assertThat(cartItems).hasSize(40);
    }
}
