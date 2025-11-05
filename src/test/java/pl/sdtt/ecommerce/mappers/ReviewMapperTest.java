package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.ReviewDTO;
import pl.sdtt.ecommerce.model.Product;
import pl.sdtt.ecommerce.model.Review;
import pl.sdtt.ecommerce.model.User;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewMapperTest {

    private final ReviewMapper reviewMapper = Mappers.getMapper(ReviewMapper.class);

    @Test
    void testToEntity() {
        //given
        Long userId = 1L;
        Long productId = 2L;
        int rating = 5;
        String comment = "Really good product!";

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .userId(userId)
                .productId(productId)
                .rating(rating)
                .comment(comment)
                .build();

        //when
        Review review = reviewMapper.toEntity(reviewDTO);

        //then
        assertThat(review).isNotNull();
        assertThat(review.getId()).isNull();
        assertThat(review.getRating()).isEqualTo(rating);
        assertThat(review.getComment()).isEqualTo(comment);
        assertThat(review.getUser()).isNotNull();
        assertThat(review.getUser().getId()).isEqualTo(userId);
        assertThat(review.getProduct()).isNotNull();
        assertThat(review.getProduct().getId()).isEqualTo(productId);

        assertThat(review.getVersion()).isEqualTo(0);
        assertThat(review.getCreatedAt()).isNull();
        assertThat(review.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long userId = 1L;
        Long productId = 2L;
        int rating = 5;
        String comment = "Really good product!";

        User user = User.builder().id(userId).build();
        Product product = Product.builder().id(productId).build();
        Review review = Review.builder()
                .user(user)
                .product(product)
                .rating(rating)
                .comment(comment)
                .build();

        //when
        ReviewDTO reviewDTO = reviewMapper.toDTO(review);

        //then
        assertThat(reviewDTO).isNotNull();
        assertThat(reviewDTO.id()).isNull();
        assertThat(reviewDTO.rating()).isEqualTo(rating);
        assertThat(reviewDTO.comment()).isEqualTo(comment);
        assertThat(reviewDTO.userId()).isNotNull();
        assertThat(reviewDTO.userId()).isEqualTo(userId);
        assertThat(reviewDTO.productId()).isNotNull();
        assertThat(reviewDTO.productId()).isEqualTo(productId);
    }

    @Test
    void testMapUserIdToUserWithNull() {
        User user = reviewMapper.mapUserIdToUser(null);
        assertThat(user).isNull();
    }

    @Test
    void testMapProductIdToProductWithNull() {
        Product product = reviewMapper.mapProductIdToProduct(null);
        assertThat(product).isNull();
    }
}
