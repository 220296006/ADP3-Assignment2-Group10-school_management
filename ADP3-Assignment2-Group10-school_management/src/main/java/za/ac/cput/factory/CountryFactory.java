package za.ac.cput.factory;
import za.ac.cput.domain.Country;
/* CountryFactory.java
 * Factory for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 11 June 2022
 */
public class CountryFactory {

    public static Country createCountry(String id, String name){

        return new Country.Builder().setId(id)
                                    .setName(name)
                                    .build();
    }
}
