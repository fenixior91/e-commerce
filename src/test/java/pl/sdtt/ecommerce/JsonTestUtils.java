package pl.sdtt.ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class JsonTestUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    public static <T> T loadMock(String path, Class<T> clazz) {
        try {
            return objectMapper.readValue(new ClassPathResource(path).getInputStream(), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Could not load mock file: " + path, e);
        }
    }
}
