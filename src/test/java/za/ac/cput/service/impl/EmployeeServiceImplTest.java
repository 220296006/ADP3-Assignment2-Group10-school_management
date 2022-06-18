package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    private final Name name = NameFactory.build("Zaeem","a","Petersen");
    private final Employee employee = EmployeeFactory.build("1","randomemail@gmail.com",name);

    @Autowired
    private EmployeeService empService;

    @Order(1)
    @Test
    void save() {
        Employee create = this.empService.save(this.employee);
        assertEquals(this.employee,create);
        System.out.println(create);
    }

    @Order(2)
    @Test
    void read() {
        Optional<Employee> view = this.empService.read(this.employee.getStaffId());
        assertAll(
                ()-> assertTrue(view.isPresent()),
                ()-> assertEquals(this.employee,view.get())
        );
    }

    /*@Test
    void delete() {
        empService.delete(employee);
        List<Employee> employeeList = this.empService.readAll();
        System.out.println(employeeList);
    }*/

    @Order(3)
    @Test
    void readAll() {
        List<Employee> employeeList = this.empService.readAll();
        assertEquals(1,employeeList.size());
    }

    @Order(4)
    @Test
    void deleteById() {
        empService.deleteById("1");
        List<Employee> employeeList = this.empService.readAll();
        System.out.println(employeeList);
    }
}