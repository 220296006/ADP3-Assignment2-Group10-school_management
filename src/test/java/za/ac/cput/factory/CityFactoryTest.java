package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    private static Country country = CountryFactory.createCountry("RT5", "Uganda");

    @Test
    void createCitySuccess() throws IllegalArgumentException {
        City city = CityFactory.createCity("KK#", "Bush-Bush", country);
        assertNotNull(city);
        assertEquals("RT5", city.getCountyId());
        System.out.println(country.getName());
    }

    @Test
    void createCityFail() {
        assertThrows(IllegalArgumentException.class, ()->{
            CityFactory.createCity("KK#", " ", country);
        });
        System.out.println("Thrown an error as expected");
    }
}