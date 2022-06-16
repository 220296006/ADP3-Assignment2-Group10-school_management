package za.ac.cput.repository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Country;
import java.util.HashSet;
import java.util.Set;
/* CountryRepository.java
 * Repository Class for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 12 June 2022
 */

@Repository
public class CountryRepository implements ICountryRepository {

    private static CountryRepository repository = null;
    private Set<Country> countryObjects = null;

    private CountryRepository(){

        countryObjects = new HashSet<Country>();
    }

    public static CountryRepository getRepository() {
        if (repository == null) {
            repository = new CountryRepository();
        }
        return repository;
    }

    @Override
    public Country save(Country country) {
        boolean success = countryObjects.add(country);
        if(!success)
            return null;
        return country;
    }

    @Override
    public Country read(String id) {
        for (Country e : countryObjects) {
            if (e.getId().equals(id))
                return e;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Country countryToDelete = read(id);
        if(countryToDelete == null)
            return false;
        countryObjects.remove(countryToDelete);
        return true;
    }

    @Override
    public Set<Country> readAll() {
        return countryObjects;
    }
}
