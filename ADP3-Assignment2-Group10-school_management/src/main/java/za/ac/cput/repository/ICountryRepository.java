package za.ac.cput.repository;
import za.ac.cput.domain.Country;
import java.util.Set;
/* IRepository.java
 * Repository for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */

public interface ICountryRepository extends IRepository<Country, String>{

    Set<Country> readAll();

}
