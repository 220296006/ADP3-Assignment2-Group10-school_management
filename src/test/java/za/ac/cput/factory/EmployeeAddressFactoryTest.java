package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    @Test
    void createEmployeeAddress() {
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("","5 Address Street");
        assertNotNull(employeeAddress);
        System.out.println(employeeAddress.toString());
    }
}