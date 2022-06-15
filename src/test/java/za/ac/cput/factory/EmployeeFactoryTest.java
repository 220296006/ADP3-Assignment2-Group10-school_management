package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    public void createEmployee() {
        Employee employee = EmployeeFactory.createEmployee("one", "myemail@gmail.com", "");
        assertNotNull(employee);
        System.out.println(employee.toString());
    }
}