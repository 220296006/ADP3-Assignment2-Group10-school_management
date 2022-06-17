package za.ac.cput.service.impl;

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
class StudentAddressServiceImplTest {

    private final StudentAddress studentAddress = StudentAddressFactory.build("002");
    private StudentAddress.StudentAddressId studentAddressId = StudentAddressFactory.buildId(this.studentAddress);

    @Autowired
    private StudentAddressService StuAddrservice;

    @Order(1)
    @Test
    void save() {
        StudentAddress create = this.StuAddrservice.save(this.studentAddress);
        assertAll(
                ()->assertNotNull(create),
                ()->assertEquals(this.studentAddress,create)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<StudentAddress> view =this.StuAddrservice.read(this.studentAddressId);
        System.out.println(view);
        assertAll(
                ()-> assertTrue(view.isPresent()),
                ()->assertEquals(this.studentAddress,view.get())

        );
    }

    @Order(4)
    @Test
    void delete() {
        this.StuAddrservice.delete(this.studentAddress);
    }

    @Order(5)
    @Test
    void findAll() {
        List<StudentAddress> studentAddressList = this.StuAddrservice.findAll();
        assertEquals(0,studentAddressList.size());
    }

    @Order(3)
    @Test
    void findByStudentId() {
        String studentId=this.studentAddressId.getStudentId();
        List<StudentAddress>studentAddressList=this.StuAddrservice.findByStudentId(studentId);
        System.out.println(studentAddressList);
        assertSame(1,studentAddressList.size());
    }
}