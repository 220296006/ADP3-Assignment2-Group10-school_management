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
public interface ICountryRepository extends JpaRepository<Country, Country.Id> {
List<Country> findAll();
Optional<Country> findById(String id);
}
