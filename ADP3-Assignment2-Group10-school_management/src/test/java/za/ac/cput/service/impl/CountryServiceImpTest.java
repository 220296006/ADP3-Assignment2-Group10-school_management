package za.ac.cput.service.impl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.CountryService;
import java.util.List;
import java.util.Optional;
/* CountryServiceImp.java
 * CountryService Implementation class for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 15 June 2022
 */
import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.util.GenericHelper.id;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImpTest {

    private final Country country = CountryFactory
            .createCountry(id(), "South Africa");

    private Country.Id id = CountryFactory.createId(this.country);

    @Autowired
    private CountryService service;

    @Test
    @Order(1)
    void save() {
        Country saved = this.service.save(this.country);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.country, saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<Country> read = this.service.read(String.valueOf(this.id));
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.country, read.get())
        );
    }
    @Test
    @Order(4)
    void delete() {
        this.service.delete(this.country);
    }

    @Test
    @Order(5)
    void findAll() {
        List<Country> countryList = this.service.findAll();
        System.out.println(countryList);
        assertSame(0, countryList.size());

    }

    @Test
    @Order(3)
    void findById(){
        String id = this.id.getId();
        List<Country> countryList = this.service.findById(id);
        assertSame(1, countryList.size());
    }
}