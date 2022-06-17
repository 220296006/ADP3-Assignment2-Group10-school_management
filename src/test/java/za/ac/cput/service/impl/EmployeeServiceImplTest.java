package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    private final Employee employee = EmployeeFactory.build("001","randomemail@gmail.com");
    private Employee.EmployeeId employeeId = EmployeeFactory.buildId(this.employee);

    @Autowired
    private EmployeeService empService;

    @Order(1)
    @Test
    void save() {
        Employee saved = this.empService.save(this.employee);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.employee,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Employee> view=this.empService.read(this.employeeId);
        System.out.println(view);
        assertAll(
                ()->assertTrue(view.isPresent()),
                ()->assertEquals(this.employee,view.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.empService.delete(this.employee);
    }

    @Order(5)
    @Test
    void findAll() {
        List<Employee> employeeList=this.empService.findAll();
        assertEquals(0,employeeList.size());
    }

    @Order(3)
    @Test
    void findByStaffId() {
        String staffId=this.employeeId.getStaffId();
        List<Employee>employeeList=this.empService.findByStaffId(staffId);
        System.out.println(employeeList);
        assertSame(1,employeeList.size());
    }
}