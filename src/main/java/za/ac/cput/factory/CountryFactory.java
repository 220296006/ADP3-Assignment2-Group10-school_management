package za.ac.cput.factory;
import za.ac.cput.domain.Country;
/* CountryFactory.java
 * Factory for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 11 June 2022
 */
public class CountryFactory {

    public static Country build(String countryId, String countryName)
    {
        if(countryId ==null ||countryId.isEmpty() )
            throw new IllegalArgumentException("Country Id is required!");
        if( countryName ==null||countryName.isEmpty() )
            throw new IllegalArgumentException("Name is required!");
        return new Country.Builder().countryId(countryId)
                .countryName(countryName).build();

    }
    public static Country.CountryIdentity buildId(Country country)
    {
        return new Country.CountryIdentity(country.getCountryId());
    }
}
