package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.CategoryDTO;
import pl.sdtt.ecommerce.model.Category;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryMapperTest {

    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Test
    void testToEntity() {
        //given
        String name = "Category";
        String description = "Category description";

        CategoryDTO categoryDTO = CategoryDTO.builder()
                .name(name)
                .description(description)
                .build();

        //when
        Category category = categoryMapper.toEntity(categoryDTO);

        //then
        assertThat(category).isNotNull();
        assertThat(category.getId()).isNull();
        assertThat(category.getName()).isEqualTo(name);
        assertThat(category.getDescription()).isEqualTo(description);

        assertThat(category.getVersion()).isEqualTo(0);
        assertThat(category.getProducts()).isNull();
        assertThat(category.getCreatedAt()).isNull();
        assertThat(category.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        String name = "Category";
        String description = "Category description";

        Category category = Category.builder()
                .name(name)
                .description(description)
                .build();

        //when
        CategoryDTO categoryDTO = categoryMapper.toDTO(category);

        //then
        assertThat(categoryDTO).isNotNull();
        assertThat(categoryDTO.id()).isNull();
        assertThat(categoryDTO.name()).isEqualTo(name);
        assertThat(categoryDTO.description()).isEqualTo(description);
    }
}
