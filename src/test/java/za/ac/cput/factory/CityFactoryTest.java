package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        City city=CityFactory
                .build("Test-Id","Cape Town");
        System.out.println(city);
        assertNotNull(city);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> CityFactory.build(null, "Cape Town"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("City ID is required!",exceptionMessage);
    }

}