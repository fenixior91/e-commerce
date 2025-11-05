package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.ProductDTO;
import pl.sdtt.ecommerce.model.Category;
import pl.sdtt.ecommerce.model.Product;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void testToEntity() {
        //given
        Long categoryId = 1L;
        String name = "Product";
        String description = "Product description";
        BigDecimal price = new BigDecimal("21.37");
        int stockQuantity = 10;
        String imageUrl = "https://example.com";

        ProductDTO productDTO = ProductDTO.builder()
                .categoryId(categoryId)
                .name(name)
                .description(description)
                .price(price)
                .stockQuantity(stockQuantity)
                .imageUrl(imageUrl)
                .build();

        //when
        Product product = productMapper.toEntity(productDTO);

        //then
        assertThat(product).isNotNull();
        assertThat(product.getId()).isNull();
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getDescription()).isEqualTo(description);
        assertThat(product.getPrice()).isEqualTo(price);
        assertThat(product.getStockQuantity()).isEqualTo(stockQuantity);
        assertThat(product.getImageUrl()).isEqualTo(imageUrl);
        assertThat(product.getCategory()).isNotNull();
        assertThat(product.getCategory()).isNotNull();
        assertThat(product.getCategory().getId()).isEqualTo(categoryId);

        assertThat(product.getVersion()).isEqualTo(0);
        assertThat(product.getCartItems()).isNull();
        assertThat(product.getOrderItems()).isNull();
        assertThat(product.getReviews()).isNull();
        assertThat(product.getCreatedAt()).isNull();
        assertThat(product.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long categoryId = 1L;
        String name = "Product";
        String description = "Product description";
        BigDecimal price = new BigDecimal("21.37");
        int stockQuantity = 10;
        String imageUrl = "https://example.com";

        Category category = Category.builder().id(categoryId).build();

        Product product = Product.builder()
                .category(category)
                .name(name)
                .description(description)
                .price(price)
                .stockQuantity(stockQuantity)
                .imageUrl(imageUrl)
                .build();

        //when
        ProductDTO productDTO = productMapper.toDTO(product);

        //then
        assertThat(productDTO).isNotNull();
        assertThat(productDTO.id()).isNull();
        assertThat(productDTO.name()).isEqualTo(name);
        assertThat(productDTO.description()).isEqualTo(description);
        assertThat(productDTO.price()).isEqualTo(price);
        assertThat(productDTO.stockQuantity()).isEqualTo(stockQuantity);
        assertThat(productDTO.imageUrl()).isEqualTo(imageUrl);
        assertThat(productDTO.categoryId()).isEqualTo(categoryId);
    }

    @Test
    void testMapCategoryIdToCategory() {
        Category category = productMapper.mapCategoryIdToCategory(null);
        assertThat(category).isNull();
    }
}
