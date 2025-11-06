package pl.sdtt.ecommerce.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdtt.ecommerce.JsonTestUtils;
import pl.sdtt.ecommerce.dto.product.ProductActiveStatusDTO;
import pl.sdtt.ecommerce.dto.product.ProductRequestDTO;
import pl.sdtt.ecommerce.dto.product.ProductResponseDTO;
import pl.sdtt.ecommerce.mappers.ProductMapper;
import pl.sdtt.ecommerce.model.Category;
import pl.sdtt.ecommerce.model.Product;
import pl.sdtt.ecommerce.repositories.CategoryRepository;
import pl.sdtt.ecommerce.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Spy
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Captor
    ArgumentCaptor<Long> productIdArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> categoryIdArgumentCaptor;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;

    // read

    @Test
    void testFindAll_whenResultIsEmpty() {
        // given
        given(productRepository.findAll()).willReturn(new ArrayList<>());

        // when
        Set<ProductResponseDTO> actual = productServiceImpl.findAll();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual).isEmpty();
    }

    @Test
    void testFindAll() {
        // given
        Product product1 = Product.builder().id(1L).name("Product 1").build();
        Product product2 = Product.builder().id(2L).name("Product 2").build();

        given(productRepository.findAll()).willReturn(Arrays.asList(product1, product2));

        // when
        Set<ProductResponseDTO> actual = productServiceImpl.findAll();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(2);
    }

    @Test
    void testFindById() {
        // given
        Product product = JsonTestUtils.loadMock("mocks/services/product-service/product-entity.json", Product.class);
        given(productRepository.findById(anyLong())).willReturn(Optional.of(product));

        // when
        Optional<ProductResponseDTO> actual = productServiceImpl.findById(1L);

        // then
        assertThat(actual).isPresent();
        assertThat(actual.get().id()).isEqualTo(1L);
        assertThat(actual.get().name()).isEqualTo("Product");
        assertThat(actual.get().description()).isEqualTo("Product description");
        assertThat(actual.get().price()).isEqualTo(new BigDecimal("21.37"));
        assertThat(actual.get().stockQuantity()).isEqualTo(10);
        assertThat(actual.get().imageUrl()).isEqualTo("https://example.com");
    }

    @Test
    void testFindById_whenProductNotFound() {
        // given
        given(productRepository.findById(anyLong())).willReturn(Optional.empty());

        // when
        Optional<ProductResponseDTO> actual = productServiceImpl.findById(1L);

        // then
        assertThat(actual).isEmpty();
    }

    // create

    @Test
    void testCreate() {
        // given
        ProductRequestDTO productToCreateDTO = JsonTestUtils.loadMock("mocks/services/product-service/product-request-dto.json", ProductRequestDTO.class);
        Product createdProduct = JsonTestUtils.loadMock("mocks/services/product-service/product-entity.json", Product.class);

        given(productRepository.save(any())).willReturn(createdProduct);

        // when
        ProductResponseDTO actual = productServiceImpl.create(productToCreateDTO);

        // then
        assertThat(actual.id()).isEqualTo(1L);
        assertThat(actual.name()).isEqualTo("Product");
        assertThat(actual.description()).isEqualTo("Product description");
        assertThat(actual.price()).isEqualTo(new BigDecimal("21.37"));
        assertThat(actual.stockQuantity()).isEqualTo(10);
        assertThat(actual.imageUrl()).isEqualTo("https://example.com");
        assertThat(actual.categoryId()).isEqualTo(1L);

        verify(productRepository).save(productArgumentCaptor.capture());

        Product captured = productArgumentCaptor.getValue();
        assertThat(captured.getId()).isNull();
        assertThat(captured.getCategory()).isNotNull();
        assertThat(captured.getCategory().getId()).isEqualTo(1L);
    }


    // update

    @Test
    void testUpdate() {
        // given
        Category category = JsonTestUtils.loadMock("mocks/services/product-service/category-entity.json", Category.class);
        Product product = JsonTestUtils.loadMock("mocks/services/product-service/product-entity.json", Product.class);
        ProductRequestDTO productToUpdateDTO = JsonTestUtils.loadMock("mocks/services/product-service/product-request-dto.json", ProductRequestDTO.class);
        Product updatedProduct = JsonTestUtils.loadMock("mocks/services/product-service/product-entity.json", Product.class);

        given(productRepository.findById(anyLong())).willReturn(Optional.of(product));
        given(productRepository.save(any())).willReturn(updatedProduct);
        given(categoryRepository.findById(anyLong())).willReturn(Optional.of(category));

        // when
        Optional<ProductResponseDTO> actual = productServiceImpl.update(1L, productToUpdateDTO);

        // then
        assertThat(actual).isPresent();
        ProductResponseDTO dto = actual.get();
        assertThat(dto.id()).isEqualTo(1L);
        assertThat(dto.name()).isEqualTo("Product");
        assertThat(dto.description()).isEqualTo("Product description");
        assertThat(dto.price()).isEqualTo(new BigDecimal("21.37"));
        assertThat(dto.stockQuantity()).isEqualTo(10);
        assertThat(dto.imageUrl()).isEqualTo("https://example.com");
        assertThat(dto.categoryId()).isEqualTo(1L);

        verify(productRepository).findById(productIdArgumentCaptor.capture());
        verify(productRepository).save(productArgumentCaptor.capture());
        verify(categoryRepository).findById(categoryIdArgumentCaptor.capture());

        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        assertThat(categoryIdArgumentCaptor.getValue()).isEqualTo(1L);

        Product captured = productArgumentCaptor.getValue();
        assertThat(captured.getName()).isEqualTo("Product updated");
        assertThat(captured.getCategory()).isEqualTo(category);
    }

    @Test
    void testUpdate_whenProductNotFound() {
        // given
        ProductRequestDTO productToUpdateDTO = JsonTestUtils.loadMock("mocks/services/product-service/product-request-dto.json", ProductRequestDTO.class);
        given(productRepository.findById(anyLong())).willReturn(Optional.empty());

        // when
        assertThrows(EntityNotFoundException.class, () -> productServiceImpl.update(1L, productToUpdateDTO));

        // then
        verify(productRepository).findById(productIdArgumentCaptor.capture());
        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        verify(productRepository, times(0)).save(any());
    }

    @Test
    void testUpdate_whenCategoryNotFound() {
        // given
        Product product = JsonTestUtils.loadMock("mocks/services/product-service/product-entity.json", Product.class);
        ProductRequestDTO productToUpdateDTO = JsonTestUtils.loadMock("mocks/services/product-service/product-request-dto.json", ProductRequestDTO.class);

        given(productRepository.findById(anyLong())).willReturn(Optional.of(product));
        given(categoryRepository.findById(anyLong())).willReturn(Optional.empty());

        // when
        assertThrows(EntityNotFoundException.class, () -> productServiceImpl.update(1L, productToUpdateDTO));

        // then
        verify(productRepository).findById(productIdArgumentCaptor.capture());
        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        verify(categoryRepository).findById(categoryIdArgumentCaptor.capture());
        assertThat(categoryIdArgumentCaptor.getValue()).isEqualTo(1L);
        verify(productRepository, times(0)).save(product);
    }


    @Test
    void testUpdateActiveStatus() {
        // given
        ProductActiveStatusDTO activeStatusDTO = new ProductActiveStatusDTO(false);
        Product productEntity = JsonTestUtils.loadMock("mocks/services/product-service/product-entity.json", Product.class);
        Product inactiveProductEntity = JsonTestUtils.loadMock("mocks/services/product-service/inactive-product-entity.json", Product.class);

        given(productRepository.findById(1L)).willReturn(Optional.of(productEntity));
        given(productRepository.save(any())).willReturn(inactiveProductEntity);

        // when
        Optional<ProductResponseDTO> actual = productServiceImpl.changeActiveStatus(1L, activeStatusDTO);

        // then
        assertThat(actual).isPresent();
        assertThat(actual.get().active()).isFalse();

        verify(productRepository).findById(productIdArgumentCaptor.capture());
        verify(productRepository).save(productArgumentCaptor.capture());

        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        assertThat(productArgumentCaptor.getValue().isActive()).isFalse();
    }

    @Test
    void testUpdateActiveStatus_whenProductNotFound() {
        ProductActiveStatusDTO activeStatusDTO = new ProductActiveStatusDTO(false);

        assertThrows(EntityNotFoundException.class, () -> productServiceImpl.changeActiveStatus(1L, activeStatusDTO));

        verify(productRepository).findById(productIdArgumentCaptor.capture());
        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        verify(productRepository, times(0)).save(any());
    }

    // delete

    @Test
    void testDelete() {
        // given
        Product product = JsonTestUtils.loadMock("mocks/services/product-service/product-entity.json", Product.class);

        given(productRepository.findById(anyLong())).willReturn(Optional.of(product));

        // when
        productServiceImpl.delete(1L);

        // then
        verify(productRepository).findById(productIdArgumentCaptor.capture());
        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        verify(productRepository, times(1)).delete(product);
    }

    @Test
    void testDelete_whenProductNotFound() {
        // given
        given(productRepository.findById(anyLong())).willReturn(Optional.empty());

        // when
        assertThrows(EntityNotFoundException.class, () -> productServiceImpl.delete(1L));

        // then
        verify(productRepository).findById(productIdArgumentCaptor.capture());
        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        verify(productRepository, times(0)).delete(any());
    }
}
