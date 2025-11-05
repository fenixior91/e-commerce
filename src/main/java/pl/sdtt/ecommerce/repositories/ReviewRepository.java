package pl.sdtt.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdtt.ecommerce.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
