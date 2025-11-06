package pl.sdtt.ecommerce.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import pl.sdtt.ecommerce.dto.product.ProductActiveStatusDTO;
import pl.sdtt.ecommerce.dto.product.ProductRequestDTO;
import pl.sdtt.ecommerce.dto.product.ProductResponseDTO;
import pl.sdtt.ecommerce.services.ProductService;

import java.net.URI;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class ProductController {

    public static final String PRODUCTS_PATH = "/api/v1/products";
    public static final String PRODUCT_ID = "productId";
    public static final String PRODUCT_PATH = PRODUCTS_PATH + "/{" + PRODUCT_ID + "}";
    private final ProductService productService;

    @PostMapping(PRODUCTS_PATH)
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productDTO, UriComponentsBuilder ucb) {
        ProductResponseDTO createdProductDTO = productService.create(productDTO);
        URI location = ucb.path(PRODUCT_PATH)
                .buildAndExpand(createdProductDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(createdProductDTO);
    }

    @GetMapping(PRODUCTS_PATH)
    public ResponseEntity<Set<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(PRODUCT_PATH)
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable(PRODUCT_ID) Long productId) {
        return productService.findById(productId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(PRODUCT_PATH)
    public ResponseEntity<ProductResponseDTO> update(@PathVariable(PRODUCT_ID) Long productId, @RequestBody ProductRequestDTO productDTO) {
        Optional<ProductResponseDTO> updatedProductDTO = productService.update(productId, productDTO);
        if (updatedProductDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(PRODUCT_PATH)
    public ResponseEntity<ProductResponseDTO> changeActiveStatus(@PathVariable(PRODUCT_ID) Long productId, @RequestBody ProductActiveStatusDTO activeStatusDTO) {
        Optional<ProductResponseDTO> updatedProductDTO = productService.changeActiveStatus(productId, activeStatusDTO);
        return updatedProductDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(PRODUCT_PATH)
    public ResponseEntity<ProductResponseDTO> update(@PathVariable(PRODUCT_ID) Long productId) {
        try {
            productService.delete(productId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}