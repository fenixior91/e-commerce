package pl.sdtt.ecommerce.services;

import pl.sdtt.ecommerce.dto.product.ProductActiveStatusDTO;
import pl.sdtt.ecommerce.dto.product.ProductRequestDTO;
import pl.sdtt.ecommerce.dto.product.ProductResponseDTO;

import java.util.Optional;
import java.util.Set;

public interface ProductService {

    Set<ProductResponseDTO> findAll();

    Optional<ProductResponseDTO> findById(Long id);

    ProductResponseDTO create(ProductRequestDTO productDTO);

    Optional<ProductResponseDTO> update(Long id, ProductRequestDTO productDTO);

    void delete(Long id);

    Optional<ProductResponseDTO> changeActiveStatus(Long id, ProductActiveStatusDTO activeStatusDTO);
}
