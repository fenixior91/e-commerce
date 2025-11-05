package pl.sdtt.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.sdtt.ecommerce.dto.CategoryDTO;
import pl.sdtt.ecommerce.model.Category;

@Mapper
public interface CategoryMapper {

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);
}
