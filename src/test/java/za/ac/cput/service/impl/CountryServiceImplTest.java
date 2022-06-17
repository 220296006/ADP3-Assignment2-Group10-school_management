package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.service.CountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImplTest {
 private final Country country = CountryFactory.build("ID1", "Japan");

 private Country.CountryIdentity countryIdentity = CountryFactory.buildId(this.country);

 @Autowired
 private CountryService countryService;

    @Order(1)
    @Test
    void save() {
        Country create = this.countryService.save(this.country);
        assertAll(
                ()->assertNotNull(create),
                ()->assertEquals(this.country,create)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Country> view = this.countryService.read(this.countryIdentity);
        System.out.println(view);
        assertAll(
                ()->assertTrue(view.isPresent()),
                ()->assertEquals(this.country,view.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.countryService.delete(this.country);
    }

    @Order(5)
    @Test
    void findAll() {
        List<Country> countryList=this.countryService.findAll();
        assertEquals(0,countryList.size());
    }

    @Order(3)
    @Test
    void findByCountryId() {
        String countryId=this.countryIdentity.getCountryId();
        List<Country>countryList=this.countryService.findByCountryId(countryId);
        System.out.println(countryList);
        assertSame(1,countryList.size());
    }
}