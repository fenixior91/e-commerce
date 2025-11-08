package pl.sdtt.ecommerce.controllers.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.sdtt.ecommerce.repositories.ProductRepository;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.sdtt.ecommerce.controllers.ProductController.PRODUCTS_PATH;
import static pl.sdtt.ecommerce.controllers.ProductController.PRODUCT_PATH;

@SpringBootTest
@ActiveProfiles("test")
public class ProductControllerIT {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ProductRepository productRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void testCreate() throws Exception {

    }

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get(PRODUCTS_PATH)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(20)));
    }

    @Test
    void testFindById() throws Exception {
        mockMvc.perform(get(PRODUCT_PATH, 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Smartfon XYZ")))
                .andExpect(jsonPath("$.description", is("Nowoczesny smartfon")))
                .andExpect(jsonPath("$.price", is(1999.99)))
                .andExpect(jsonPath("$.stockQuantity", is(10)))
                .andExpect(jsonPath("$.imageUrl", is("https://example.com/xyz.jpg")))
                .andExpect(jsonPath("$.categoryId", is(1)))
                .andExpect(jsonPath("$.createdAt", is("2025-10-25T13:00:00")))
                .andExpect(jsonPath("$.updatedAt", is("2025-10-25T13:00:00")));
    }

    @Test
    void testFindById_whenProductNotFound() throws Exception {
        mockMvc.perform(get(PRODUCT_PATH, 999L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
