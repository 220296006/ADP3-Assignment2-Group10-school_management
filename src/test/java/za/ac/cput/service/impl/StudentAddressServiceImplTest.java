package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.StudentAddressFactory;
import za.ac.cput.service.service.StudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplTest {

    //create everything needed for StudentAddress before creating studentAddress
    private final Country country = CountryFactory.build("3", "SA");
    private final City city = CityFactory.build("3", "SA", country);
    private final Address address = AddressFactory.build("03", "bedford", "21","randomstreet"
            ,"5464", city);
    private final StudentAddress studentAddress = StudentAddressFactory.build("3", address);

    @Autowired
    private StudentAddressService StuAddrservice;

    @Order(1)
    @Test
    void save() {
        StudentAddress create = this.StuAddrservice.save(this.studentAddress);
        assertEquals(this.studentAddress, create);
        System.out.println(create);
    }

    @Order(2)
    @Test
    void read() {
        Optional<StudentAddress> view = this.StuAddrservice.read(this.studentAddress.getStudentId());
        assertAll(
                ()-> assertTrue(view.isPresent()),
                ()-> assertEquals(this.studentAddress,view.get())
        );
    }

/*    @Test
    void delete() {
        StuAddrservice.delete(studentAddress);
        List<StudentAddress> studentAddrList = this.StuAddrservice.readAll();
        System.out.println(studentAddrList);
    }*/

    @Order(3)
    @Test
    void readAll() {
        List<StudentAddress> studentAddrList = this.StuAddrservice.readAll();
        assertEquals(1,studentAddrList.size());
    }

    @Order(4)
    @Test
    void deleteById() {
        StuAddrservice.deleteById("3");
        List<StudentAddress> studentAddrList = this.StuAddrservice.readAll();
        System.out.println(studentAddrList);
    }
}