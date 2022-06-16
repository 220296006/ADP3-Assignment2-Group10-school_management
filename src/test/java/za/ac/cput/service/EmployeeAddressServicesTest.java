package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.EmployeeAddressFactory;
import za.ac.cput.service.impl.EmployeeAddressServices;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeAddressServicesTest {
    private static EmployeeAddressServices services = (EmployeeAddressServices) EmployeeAddressServices.getServices();
    private static EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("","20 Address Street");

    @Test
    void d_getAll() {
        System.out.println("Show All : ");
        System.out.println(services.getAll());
    }

    @Test
    void a_create() {
        EmployeeAddress created = services.create(employeeAddress);
        assertEquals(employeeAddress.getStaffId(),created.getStaffId());
        System.out.println(employeeAddress.toString());
    }

    @Test
    void b_read() {
        EmployeeAddress scan = services.read(employeeAddress.getStaffId());
        assertNotNull(scan);
        System.out.print("Read : " + scan );
    }

    @Test
    void c_update() {
        EmployeeAddress updated = new EmployeeAddress.Builder().copy(employeeAddress).setAddress("55 Town Road").build();
        assertNotNull(services.update(updated));
        System.out.print("Updated : " + updated);
    }

    @Test
    void e_delete() {
        boolean success = services.delete(employeeAddress.getStaffId());
        assertTrue(success);
        System.out.println("Deleted : " + success);
    }
}