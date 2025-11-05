package pl.sdtt.ecommerce.services;

import pl.sdtt.ecommerce.dto.ProductDTO;

import java.util.Optional;
import java.util.Set;

public interface ProductService {

    Set<ProductDTO> findAll();

    Optional<ProductDTO> findById(Long id);

    Optional<ProductDTO> create(ProductDTO productDTO);

    Optional<ProductDTO> update(Long id, ProductDTO productDTO);

    void delete(Long id);
}
