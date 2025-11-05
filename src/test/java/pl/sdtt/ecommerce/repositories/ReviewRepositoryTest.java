package pl.sdtt.ecommerce.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.sdtt.ecommerce.model.Review;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void testFindAll() {
        Set<Review> reviews = new HashSet<>(reviewRepository.findAll());

        assertThat(reviews).isNotEmpty();
        assertThat(reviews).hasSize(20);
    }
}
