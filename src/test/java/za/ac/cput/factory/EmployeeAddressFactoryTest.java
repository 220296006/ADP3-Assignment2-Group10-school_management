package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    @Test
    public void buildWithSuccess()
    {
        EmployeeAddress employeeAddress=EmployeeAddressFactory
                .build("01", new Address());
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> EmployeeAddressFactory.build("02", null));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("address is null",exceptionMessage);
    }

}