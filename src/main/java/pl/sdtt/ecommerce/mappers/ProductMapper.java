package pl.sdtt.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.sdtt.ecommerce.dto.product.ProductRequestDTO;
import pl.sdtt.ecommerce.dto.product.ProductResponseDTO;
import pl.sdtt.ecommerce.model.Category;
import pl.sdtt.ecommerce.model.Product;

@Mapper
public interface ProductMapper {

    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategoryIdToCategory")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "cartItems", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product toEntity(ProductRequestDTO productDTO);

    @Mapping(target = "categoryId", source = "category.id")
    ProductResponseDTO toDTO(Product product);

    @Named("mapCategoryIdToCategory")
    default Category mapCategoryIdToCategory(Long categoryId) {
        if (categoryId == null) return null;
        Category category = new Category();
        category.setId(categoryId);
        return category;
    }
}
