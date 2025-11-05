package pl.sdtt.ecommerce.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.sdtt.ecommerce.model.Category;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testFindAll() {
        Set<Category> categories = new HashSet<>(categoryRepository.findAll());

        assertThat(categories).isNotEmpty();
        assertThat(categories).hasSize(5);
    }
}
