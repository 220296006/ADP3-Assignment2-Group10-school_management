package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Country;

import static za.ac.cput.Util.GenericHelper.id;
/* CountryFactoryTest.java
 * CountryFactoryTest for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 11 June 2022
 */
class CountryFactoryTest {

    @Test
    public void createCountry() {
        Country country = CountryFactory.createCountry(id(),"South Africa" );
        System.out.println(country);
    }
}