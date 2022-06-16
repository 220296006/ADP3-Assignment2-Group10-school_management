/**AddressFactoryTest.java
 * This the test case for AddressFactory
 * Author: Daniella Burgess 219446482
 * Date: 15 June 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

class AddressFactoryTest {

    @Test public void buildSuccessfully(){
        Address address = AddressFactory
                .build("","","23","Duck Road", 1000, "" );
        System.out.println(address);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(address),
                () -> Assertions.assertNotNull(address.getUnitNumber(), address.getComplexNumber()));

    }

    @Test public void buildFail() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                AddressFactory
                        .build("null","","23","",1, "" ));
        String exceptionMessage = exception.getMessage();
        Assertions.assertSame("Street number is required", exceptionMessage);
    }
}