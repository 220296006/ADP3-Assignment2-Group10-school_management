package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.City;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.service.service.CityService;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {

    private final City city = CityFactory.build("1", "cape town");

    private City.CityId cityId = CityFactory.buildId(this.city);

    @Autowired
    private CityService cityService;


    @Order(1)
    @Test
    void save() {
        City create = this.cityService.save(this.city);
        assertAll(
                ()->assertNotNull(create),
                ()->assertEquals(this.city,create)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<City> view = this.cityService.read(this.cityId);
        System.out.println(view);
        assertAll(
                ()->assertTrue(view.isPresent()),
                ()->assertEquals(this.city,view.get())
        );

    }

    @Order(4)
    @Test
    void delete() {
        this.cityService.delete(this.city);
    }

    @Order(5)
    @Test
    void findAll() {
        List<City> cityList=this.cityService.findAll();
        assertEquals(0,cityList.size());
    }

    @Order(3)
    @Test
    void findById() {
        String Cid=this.cityId.getId();
        List<City>cityList=this.cityService.findById(Cid);
        System.out.println(cityList);
        assertSame(1,cityList.size());
    }
}