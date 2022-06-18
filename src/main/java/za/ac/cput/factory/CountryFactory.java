package za.ac.cput.factory;
import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.Country;
/* CountryFactory.java
 * Factory for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 11 June 2022
 */
public class CountryFactory {

    public static Country build(String countryId, String countryName) {

        if(GenericHelper.isNullorEmpty(countryId)|| GenericHelper.isNullorEmpty(countryName))
            throw new IllegalArgumentException("countryid or countryName is null or empty");

        return new Country.Builder().countryId(countryId)
                                    .countryName(countryName)
                                    .build();
    }

}
