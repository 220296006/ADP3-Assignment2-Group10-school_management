/**AddressFactoryTest.java
 * This the test case for AddressFactory
 * Author: Daniella Burgess 219446482
 * Date: 15 June 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Address address=AddressFactory.build("test-unit-number","test-complex-number","test-street-Number","test-street-Name","1234");
        System.out.println(address);
        assertNotNull(address);
    }
    @Test
    void buildwithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> AddressFactory.build(null,"test-complex-name","test-street-Number","test-street-Name","1234"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("unit number is required",exceptionMessage);
    }

}