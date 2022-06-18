package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.EmployeeAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private EmployeeAddressController controller;
    @Autowired private TestRestTemplate restTemplate;
    private EmployeeAddress employeeAddress;
    private Address address;
    private City city;
    private Country country;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {

        this.country = CountryFactory.build("9", "Japan");
        this.city = CityFactory.build("9", "kyoto", country);
        this.address = AddressFactory.build("6", "qwerty", "5", "aaaa","4568", city);
        this.employeeAddress= EmployeeAddressFactory.build("1", address);
        this.baseUrl="http://localhost:"+ this.port + "/schoolmanagement/employeeAddress/";
    }
    @Test
    @Order(1)
    void save()
    {
        String url=baseUrl+ "save/";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response=this.restTemplate
                .postForEntity(url,this.employeeAddress,EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }
   @Test
    @Order(2)
    void read()
   {
       String url=baseUrl +"read/" + this.employeeAddress.getStaffId();
       System.out.println(url);
       ResponseEntity<EmployeeAddress>response=this.restTemplate.getForEntity(url,EmployeeAddress.class);
       System.out.println(response);
       assertAll(
               ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
               ()->assertNotNull(response.getBody())
       );
   }

   @Test
    @Order(4)
    void delete()
   {
       String url=baseUrl + "delete/" + this.employeeAddress.getStaffId();
       this.restTemplate.delete(url,controller.delete(url));
   }
   @Test
    @Order(3)
    void findAll()
   {
       String url=baseUrl +"all";
       System.out.println(url);
       ResponseEntity<EmployeeAddress[]> response=this.restTemplate.getForEntity(url,EmployeeAddress[].class);
       System.out.println(Arrays.asList(response.getBody()));
       assertAll(
               ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
               ()->assertTrue(response.getBody().length==3)
       );
   }
}
