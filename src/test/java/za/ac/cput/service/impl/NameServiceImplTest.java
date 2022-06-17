package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.service.NameService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NameServiceImplTest {

    private final Name name = NameFactory.build("Zaeem","N/A","Petersen");
    private Name.NameId nameId = NameFactory.buildId(this.name);

    @Autowired
    private NameService nameService;

    @Order(1)
    @Test
    void save() {
        Name create = this.nameService.save(this.name);
        assertAll(
                ()->assertNotNull(create),
                ()->assertEquals(this.name,create)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Name> view = this.nameService.read(this.nameId);
        System.out.println(view);
        assertAll(
                ()->assertTrue(view.isPresent()),
                ()->assertEquals(this.name,view.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.nameService.delete(this.name);
    }

    @Order(5)
    @Test
    void findAll() {
        List<Name> nameList = this.nameService.findAll();
        assertEquals(0,nameList.size());
    }

    @Order(3)
    @Test
    void findByFirstName() {
        String firstName = this.nameId.getFirstName();
        List<Name>NList = this.nameService.findByFirstName(firstName);
        System.out.println(NList);
        assertSame(1,NList.size());
    }
}