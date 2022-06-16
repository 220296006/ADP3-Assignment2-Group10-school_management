package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Employee employee=EmployeeFactory
                .build("test-id","warrenjaftha16@gmail.com" );
        System.out.println(employee);
        assertNotNull(employee);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> EmployeeFactory.build(null,"warrenjaftha16@gmail.com"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("staff ID is required",exceptionMessage);
    }

}