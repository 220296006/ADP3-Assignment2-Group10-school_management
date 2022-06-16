package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Country;
import java.util.List;
import java.util.Optional;

/* IRepository.java
 * Repository for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */
@Repository
public interface ICountryRepository extends IRepository<Country, Country.CountryIdentity> {
List<Country> findAll();
    List<Country> findByCountryId(String countryId);
}
