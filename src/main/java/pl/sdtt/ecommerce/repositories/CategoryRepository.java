package pl.sdtt.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdtt.ecommerce.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
