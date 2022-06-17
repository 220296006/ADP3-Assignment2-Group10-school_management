package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NameControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private NameController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Name name;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        this.name= NameFactory.build("Zelino","none","Pestana");
        this.baseUrl="http://localhost:" +this.port+"/schoolmanagement/name/";

    }
    @Test
    @Order(1)
    void save()
    {
        String url=baseUrl+ "save";
        System.out.println(url);
        ResponseEntity<Name>response=this.restTemplate
                .postForEntity(url,this.name,Name.class);
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
        String url=baseUrl+"delete/" +this.name.getFirstName();
        this.restTemplate.delete(url,controller.delete(name));
    }
    @Test
    @Order(2)
    void read()
    {
        String url=baseUrl +"read/"+ this.name.getFirstName();
        System.out.println(url);
        ResponseEntity<Name>response=this.restTemplate.getForEntity(url,Name.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void findAll()
    {
        String url=baseUrl +"all";
        System.out.println(url);
        ResponseEntity<Name[]>response=this.restTemplate.getForEntity(url,Name[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertTrue(response.getBody().length==0)
        );
    }
}
