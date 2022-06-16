package za.ac.cput.factory;

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.school_management.util.Helper;

public class CityFactory {

    public static City createCity(String id, String name, Country country) throws IllegalArgumentException{
        if(!Helper.isValidString(id) || !Helper.isValidString(name) || country == null)
            throw new IllegalArgumentException("IllegalArgumentException");
        return new City.Builder().setId(id).setName(name).setCountry(country.getId()).build();
    }
}
