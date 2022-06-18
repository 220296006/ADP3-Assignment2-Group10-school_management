package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Employee employee=EmployeeFactory
                .build("03","randomemail@gmail.com", new Name());
        System.out.println(employee);
        assertNotNull(employee);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> EmployeeFactory.build("03","randomemail@gmail.com", null));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("name is null",exceptionMessage);
    }

}