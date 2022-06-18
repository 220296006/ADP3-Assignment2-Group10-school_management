/**AddressFactoryTest.java
 * This the test case for AddressFactory
 * Author: Daniella Burgess 219446482
 * Date: 15 June 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Address address=AddressFactory.build("22","11","55","street","4321", new City());
        System.out.println(address);
        assertNotNull(address);
    }
    @Test
    void buildwithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> AddressFactory.build(null,"11","22","33","1234", new City()));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("unit number is null",exceptionMessage);
    }

}