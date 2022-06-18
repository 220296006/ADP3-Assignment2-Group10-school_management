package za.ac.cput.factory;

/*Waseem Dollie - 216040566*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        StudentAddress studentAddress=StudentAddressFactory
                .build("01", new Address());
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> StudentAddressFactory.build("01", null));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("address is required!",exceptionMessage);
    }

}