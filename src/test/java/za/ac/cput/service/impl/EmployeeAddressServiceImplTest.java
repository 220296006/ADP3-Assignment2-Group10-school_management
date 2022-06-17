package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.EmployeeAddressFactory;
import za.ac.cput.service.service.EmployeeAddressService;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplTest {

    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("01");
    private EmployeeAddress.EmployeeAddressId employeeAddressId = EmployeeAddressFactory.buildId(this.employeeAddress);

    @Autowired
    private EmployeeAddressService EAservice;

    @Order(1)
    @Test
    void save() {
        EmployeeAddress create = this.EAservice.save(this.employeeAddress);
        assertAll(
                ()->assertNotNull(create),
                ()->assertEquals(this.employeeAddress,create)
        );
    }
    @Order(2)
    @Test
    void read() {
        Optional<EmployeeAddress> view = this.EAservice.read(this.employeeAddressId);
        System.out.println(view);
        assertAll(
                ()-> assertTrue(view.isPresent()),
                ()->assertEquals(this.employeeAddress,view.get())

        );
    }
    @Order(4)
    @Test
    void delete() {
        this.EAservice.delete(this.employeeAddress);
    }
    @Order(5)
    @Test
    void findAll() {
        List<EmployeeAddress> employeeAddressList=this.EAservice.findAll();
        assertEquals(0,employeeAddressList.size());
    }
    @Order(3)
    @Test
    void findByStaffId() {
        String staffId = this.employeeAddressId.getStaffId();
        List<EmployeeAddress>employeeAddressList= this.EAservice.findByStaffId(staffId);
        System.out.println(employeeAddressList);
        assertSame(1,employeeAddressList.size());
    }
}