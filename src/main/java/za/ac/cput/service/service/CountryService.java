package za.ac.cput.service.service;

/* ICountryService.java
 * CountryService Interface for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */
import za.ac.cput.domain.Country;
import za.ac.cput.service.IService;

import java.util.List;

public interface CountryService extends IService<Country,Country.CountryIdentity> {
    List<Country> findAll();
    //void deleteById(String id);
    List<Country> findByCountryId(String countryId);
}

