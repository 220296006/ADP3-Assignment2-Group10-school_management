package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.impl.CityServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CityServiceImplTest {

    @Autowired
    private CityServiceImpl cityService;


    private static Country country = CountryFactory.createCountry("CHI", "China");
    private static City city = CityFactory.createCity("WHU", "Wuhan", country);



    @Test
    void b_create() {
        assertNotNull(cityService.save(city));
    }

    @Test
    void c_read() {
        assertEquals("CHI",cityService.read("Wuhan").getCountyId());
        City t = cityService.read("Wuhan");
        System.out.println(t.getCountyId());
        System.out.println(t.getName());
        System.out.println(t.getId());
    }

    @Test
    void d_update() {
        City x = new City.Builder().copy(city).setName("Chile").build();
        assertNotNull(cityService.save(x));
    }

    @Test
    void f_delete() {
        cityService.delete(city);
    }

    @Test
    void e_getAll() {
        assertEquals(1, cityService.getAll().size());
    }
}