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
import za.ac.cput.factory.EmployeeAddressFactory;
import za.ac.cput.service.service.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplTest {

    private final Country country = CountryFactory.build("7","SOUTHAFRICA");
    private final City city = CityFactory.build("7", "CapeTownn", country);
    private final Address address = AddressFactory.build("7", "complex", "7",
            "thestreet", "7777", city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("01",address);

    @Autowired
    private EmployeeAddressService EAservice;

    @Order(1)
    @Test
    void save() {
        EmployeeAddress create = this.EAservice.save(this.employeeAddress);
        assertEquals(this.employeeAddress, create);
        System.out.println(create);
    }

    @Order(2)
    @Test
    void read() {
        Optional<EmployeeAddress> view = this.EAservice.read(this.employeeAddress.getStaffId());
        assertAll(
                ()-> assertTrue(view.isPresent()),
                ()-> assertEquals(this.employeeAddress,view.get())
        );
    }

  /*  @Test
    void delete() {
    }*/
    @Order(3)
    @Test
    void readAll() {
        List<EmployeeAddress> employeeAddressList = this.EAservice.readAll();
        assertEquals(1,employeeAddressList.size());
    }

    @Order(4)
    @Test
    void deleteById() {
        EAservice.deleteById("7");
        List<EmployeeAddress> employeeAddressList = this.EAservice.readAll();
        System.out.println(employeeAddressList);
    }
}