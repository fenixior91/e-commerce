package pl.sdtt.ecommerce.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.sdtt.ecommerce.JsonTestUtils;
import pl.sdtt.ecommerce.dto.product.ProductRequestDTO;
import pl.sdtt.ecommerce.dto.product.ProductResponseDTO;
import pl.sdtt.ecommerce.services.ProductService;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.sdtt.ecommerce.controllers.ProductController.PRODUCTS_PATH;
import static pl.sdtt.ecommerce.controllers.ProductController.PRODUCT_PATH;

@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProductService productService;

    @Captor
    ArgumentCaptor<Long> productIdArgumentCaptor;

    @Captor
    ArgumentCaptor<ProductRequestDTO> productRequestDTOArgumentCaptor;

    @Test
    void testCreate() throws Exception {
        // given
        ProductRequestDTO productToCreate = JsonTestUtils.loadMock("mocks/controllers/product-controller/product-request-dto.json", ProductRequestDTO.class);
        ProductResponseDTO createdProduct = JsonTestUtils.loadMock("mocks/controllers/product-controller/product-response-dto.json", ProductResponseDTO.class);
        given(productService.create(productToCreate)).willReturn(createdProduct);

        // then
        mockMvc.perform(post(PRODUCTS_PATH)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productToCreate)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Product")))
                .andExpect(jsonPath("$.description", is("Product description")))
                .andExpect(jsonPath("$.price", is(22)))
                .andExpect(jsonPath("$.stockQuantity", is(9)))
                .andExpect(jsonPath("$.imageUrl", is("https://example.com")))
                .andExpect(jsonPath("$.categoryId", is(1)));

        verify(productService).create(productRequestDTOArgumentCaptor.capture());

        assertThat(productRequestDTOArgumentCaptor.getValue()).isEqualTo(productToCreate);
    }

    @Test
    void testFindAll() throws Exception {
        // given
        Set<ProductResponseDTO> products = JsonTestUtils.loadMock("mocks/controllers/product-controller/product-dto-list.json", new TypeReference<>() {
        });
        given(productService.findAll()).willReturn(products);

        // then
        mockMvc.perform(get(PRODUCTS_PATH)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(2)));
    }

    @Test
    void testFindById() throws Exception {
        // given
        ProductResponseDTO product = JsonTestUtils.loadMock("mocks/controllers/product-controller/product-response-dto.json", ProductResponseDTO.class);
        given(productService.findById(1L)).willReturn(Optional.of(product));

        // then
        mockMvc.perform(get(PRODUCT_PATH, 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Product")))
                .andExpect(jsonPath("$.description", is("Product description")))
                .andExpect(jsonPath("$.price", is(22)))
                .andExpect(jsonPath("$.stockQuantity", is(9)))
                .andExpect(jsonPath("$.imageUrl", is("https://example.com")))
                .andExpect(jsonPath("$.categoryId", is(1)));

        verify(productService).findById(productIdArgumentCaptor.capture());

        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
    }

    @Test
    void testFindById_whenProductNotFound() throws Exception {
        // given
        given(productService.findById(1L)).willReturn(Optional.empty());

        // then
        mockMvc.perform(get(PRODUCT_PATH, 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(productService).findById(productIdArgumentCaptor.capture());

        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
    }

    @Test
    void testUpdate() throws Exception {
        // given
        ProductRequestDTO productToUpdate = JsonTestUtils.loadMock("mocks/controllers/product-controller/product-request-dto.json", ProductRequestDTO.class);
        ProductResponseDTO updatedProduct = JsonTestUtils.loadMock("mocks/controllers/product-controller/product-response-dto.json", ProductResponseDTO.class);
        given(productService.update(1L, productToUpdate)).willReturn(Optional.of(updatedProduct));

        // then
        mockMvc.perform(put(PRODUCT_PATH, 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productToUpdate)))
                .andExpect(status().isNoContent());

        verify(productService).update(productIdArgumentCaptor.capture(), productRequestDTOArgumentCaptor.capture());

        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
        assertThat(productRequestDTOArgumentCaptor.getValue()).isEqualTo(productToUpdate);
    }

    @Test
    void testDelete() throws Exception {
        // then
        mockMvc.perform(delete(PRODUCT_PATH, 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(productService).delete(productIdArgumentCaptor.capture());

        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
    }

    @Test
    void testDelete_whenProductNotFound() throws Exception {
        // given
        willThrow(EntityNotFoundException.class).given(productService).delete(1L);

        // then
        mockMvc.perform(delete(PRODUCT_PATH, 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(productService).delete(productIdArgumentCaptor.capture());

        assertThat(productIdArgumentCaptor.getValue()).isEqualTo(1L);
    }
}