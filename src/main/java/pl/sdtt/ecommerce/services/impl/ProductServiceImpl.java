package pl.sdtt.ecommerce.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdtt.ecommerce.dto.product.ProductActiveStatusDTO;
import pl.sdtt.ecommerce.dto.product.ProductRequestDTO;
import pl.sdtt.ecommerce.dto.product.ProductResponseDTO;
import pl.sdtt.ecommerce.mappers.ProductMapper;
import pl.sdtt.ecommerce.model.Category;
import pl.sdtt.ecommerce.model.Product;
import pl.sdtt.ecommerce.repositories.CategoryRepository;
import pl.sdtt.ecommerce.repositories.ProductRepository;
import pl.sdtt.ecommerce.services.ProductService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public Set<ProductResponseDTO> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDTO).collect(Collectors.toSet());
    }

    @Override
    public Optional<ProductResponseDTO> findById(Long id) {
        return productRepository.findById(id).map(productMapper::toDTO);
    }

    @Override
    public ProductResponseDTO create(ProductRequestDTO productDTO) {
        Product productToUpdate = productMapper.toEntity(productDTO);
        Product createdProduct = productRepository.save(productToUpdate);
        return productMapper.toDTO(createdProduct);
    }

    @Override
    public Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productDTO) {
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product " + id + " not found"));

        Category foundCategory = categoryRepository.findById(productDTO.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category " + productDTO.categoryId() + " not found"));

        foundProduct.setName(productDTO.name());
        foundProduct.setDescription(productDTO.description());
        foundProduct.setPrice(productDTO.price());
        foundProduct.setStockQuantity(productDTO.stockQuantity());
        foundProduct.setImageUrl(productDTO.imageUrl());
        foundProduct.setCategory(foundCategory);

        return Optional.of(productMapper.toDTO(productRepository.save(foundProduct)));
    }

    @Override
    public void delete(Long id) {
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product " + id + " not found"));

        productRepository.delete(foundProduct);
    }

    @Override
    public Optional<ProductResponseDTO> changeActiveStatus(Long id, ProductActiveStatusDTO activeStatusDTO) {
        Product foundProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product " + id + " not found"));

        foundProduct.setActive(activeStatusDTO.active());

        return Optional.of(productMapper.toDTO(productRepository.save(foundProduct)));
    }
}
