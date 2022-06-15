package za.ac.cput.service;

/*Waseem Dollie - 216040566*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.factory.StudentAddressFactory;
import za.ac.cput.service.service.StudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAddressServiceImplTest {

    public final StudentAddress studentAddress= StudentAddressFactory
            .build("test-student-id");
    public StudentAddress.StudentAddressId studentAddressId=StudentAddressFactory
            .buildId(this.studentAddress);

    @Autowired
    public StudentAddressService service;

    @Test
    @Order(1)
    void save(){
        StudentAddress saved=this.service.save(this.studentAddress);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.studentAddress,saved)
        );
    }

    @Test
    @Order(4)
    void tearDown() {
        this.service.delete(this.studentAddress);}

    @Test
    @Order(2)
    void read() {
        Optional<StudentAddress> read = this.service.read(this.studentAddressId);
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.studentAddress, read.get())
        );
    }

    @Test
    @Order(5)
    void findAll() {
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(0, studentAddressList.size());
    }

    @Test
    @Order(3)
    void findByStudentId(){
        String studentId=this.studentAddressId.getStudentId();
        List<StudentAddress>studentAddressList=
                this.service.findByStudentId(studentId);
        System.out.println(studentAddressList);
        assertSame(1,studentAddressList.size());
    }
}
