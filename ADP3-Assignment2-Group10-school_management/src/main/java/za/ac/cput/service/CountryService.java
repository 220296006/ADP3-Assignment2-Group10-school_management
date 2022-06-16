package za.ac.cput.service;
import za.ac.cput.domain.Country;
import java.util.List;
import java.util.Optional;
/* ICountryService.java
 * CountryService Interface for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */

public interface CountryService extends IService<Country, Country.Id>{
    List<Country>findAll();
    List<Country> findById(String id);
}
