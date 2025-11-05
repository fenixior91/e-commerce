package pl.sdtt.ecommerce.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pl.sdtt.ecommerce.dto.AddressDTO;
import pl.sdtt.ecommerce.model.Address;
import pl.sdtt.ecommerce.model.User;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressMapperTest {

    private final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    @Test
    void testToEntity() {
        //given
        Long userId = 1L;
        String street = "Marszałkowska";
        String city = "Warsaw";
        String zip = "64-800";
        String country = "Poland";

        AddressDTO addressDTO = AddressDTO.builder()
                .userId(userId)
                .street(street)
                .city(city)
                .zip(zip)
                .country(country)
                .build();

        //when
        Address address = addressMapper.toEntity(addressDTO);

        //then
        assertThat(address).isNotNull();
        assertThat(address.getId()).isNull();
        assertThat(address.getStreet()).isEqualTo(street);
        assertThat(address.getCity()).isEqualTo(city);
        assertThat(address.getZip()).isEqualTo(zip);
        assertThat(address.getCountry()).isEqualTo(country);
        assertThat(address.getUser()).isNotNull();
        assertThat(address.getUser().getId()).isEqualTo(userId);

        assertThat(address.getVersion()).isEqualTo(0);
        assertThat(address.getOrders()).isNull();
        assertThat(address.getCreatedAt()).isNull();
        assertThat(address.getUpdatedAt()).isNull();
    }

    @Test
    void testToDTO() {
        //given
        Long userId = 1L;
        String street = "Marszałkowska";
        String city = "Warsaw";
        String zip = "64-800";
        String country = "Poland";

        User user = User.builder().id(userId).build();
        Address address = Address.builder()
                .user(user)
                .street(street)
                .city(city)
                .zip(zip)
                .country(country)
                .build();

        //when
        AddressDTO addressDTO = addressMapper.toDTO(address);

        //then
        assertThat(addressDTO).isNotNull();
        assertThat(addressDTO.id()).isNull();
        assertThat(addressDTO.street()).isEqualTo(street);
        assertThat(addressDTO.city()).isEqualTo(city);
        assertThat(addressDTO.zip()).isEqualTo(zip);
        assertThat(addressDTO.country()).isEqualTo(country);
        assertThat(addressDTO.userId()).isNotNull();
        assertThat(addressDTO.userId()).isEqualTo(userId);
    }

    @Test
    void testMapUserIdToUser() {
        User user = addressMapper.mapUserIdToUser(null);
        assertThat(user).isNull();
    }
}
