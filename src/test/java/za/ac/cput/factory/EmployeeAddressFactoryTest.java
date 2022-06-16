package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    @Test
    public void buildWithSuccess()
    {
        EmployeeAddress employeeAddress=EmployeeAddressFactory
                .build("test-id");
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> EmployeeAddressFactory.build(null));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("staff ID is required",exceptionMessage);
    }

}