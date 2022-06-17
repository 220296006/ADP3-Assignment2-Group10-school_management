package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private AddressController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Address address;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        this.address= AddressFactory.build("test-unit-number2","test-complex-number","test-street-Number","test-street-Name","1234");
        this.baseUrl="http://localhost:" +this.port+"/schoolmanagement/address/";
    }
    @Test
    @Order(1)
    void save()
    {
        String url=baseUrl+"save";
        System.out.println(url);
        ResponseEntity<Address>response=this.restTemplate.postForEntity(url,this.address,Address.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(3)
    void delete()
    {
        String url=baseUrl+ "delete/" + this.address.getUnitNumber();
        this.restTemplate.delete(url,controller.delete(address));
    }
    @Test
    @Order(2)
    void read()
    {
        String url=baseUrl +"read/" + this.address.getUnitNumber();
        System.out.println(url);
        ResponseEntity<Address>response=this.restTemplate.getForEntity(url,Address.class);
        System.out.println(response);
        assertAll(

                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertNotNull(response.getBody())

        );
    }
    @Test
    @Order(4)
    void findAll()
    {
        String url=baseUrl +"all";
        System.out.println(url);
        ResponseEntity<Address[]>response=this.restTemplate.getForEntity(url,Address[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertTrue(response.getBody().length==0)
        );
    }
}
