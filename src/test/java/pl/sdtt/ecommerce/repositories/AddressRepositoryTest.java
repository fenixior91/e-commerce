package pl.sdtt.ecommerce.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.sdtt.ecommerce.model.Address;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void testFindAll() {
        Set<Address> addresses = new HashSet<>(addressRepository.findAll());

        assertThat(addresses).isNotEmpty();
        assertThat(addresses).hasSize(10);
    }
}
