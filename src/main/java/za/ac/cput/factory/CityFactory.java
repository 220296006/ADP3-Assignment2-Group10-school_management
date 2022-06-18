package za.ac.cput.factory;

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;


public class CityFactory {
    public static City build(String id, String name, Country country){

        if(GenericHelper.isNullorEmpty(id)|| GenericHelper.isNullorEmpty(name))
            throw new IllegalArgumentException("id or name is null or empty");

        return new City.Builder().setId(id)
                                .setName(name)
                                .setCountry(country)
                                .build();

    }
}