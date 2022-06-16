package za.ac.cput.factory;

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.school_management.util.Helper;

public class CityFactory {
    public static City build(String id, String name)
    {
        if(id ==null ||id.isEmpty() )
            throw new IllegalArgumentException("City Id is required!");
        if( name ==null||name.isEmpty() )
            throw new IllegalArgumentException("Name is required!");
        return new City.Builder().id(id)
                .name(name).build();

    }
    public static City.CityId buildId(City city)
    {
        return new City.CityId(city.getId());
    }
}