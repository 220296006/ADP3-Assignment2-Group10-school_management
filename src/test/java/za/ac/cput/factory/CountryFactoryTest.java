package za.ac.cput.factory;
/* CountryFactoryTest.java
 * CountryFactoryTest for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 11 June 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Country country=CountryFactory
                .build("Test-Id","South Africa");
        System.out.println(country);
        assertNotNull(country);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> CountryFactory.build(null, "South Africa"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Country ID is required!",exceptionMessage);
    }

}
