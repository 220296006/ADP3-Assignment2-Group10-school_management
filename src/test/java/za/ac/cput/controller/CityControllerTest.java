package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityControllerTest {

    @Autowired
    private CityController controller;
    @Autowired private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/city";
    private static Country country;
    private static City city;

    @Order(0)
    @Test
    void init() {
        country = CountryFactory.createCountry("5977", "Cameroon");
        city = CityFactory.createCity("441","Lions",country);
        assertNotNull(controller);
        assertNotNull(country);
        assertNotNull(city);
        System.out.println(country);
        System.out.println(city);
    }

    @Order(1)
    @Test
    void save(){
        System.out.println(baseUrl);
        System.out.println("Sending >> " + this.city);
        String url = baseUrl + "/create";
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city, City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "/read/" + this.city.getName();
        System.out.println(url);
        ResponseEntity<City> response =
                this.restTemplate.getForEntity(url, City.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "/delete";
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city, City.class);
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void getAll(){
        String url = baseUrl + "/getall";
        System.out.println(url);
        ResponseEntity<City[]> response =
                this.restTemplate.getForEntity(url, City[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}