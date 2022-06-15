package za.ac.cput.repository;
import java.util.Optional;

/* IRepository.java
 * Repository Interface for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 12 June 2022
 */
public interface IRepository<T, ID>{

    T save(T t);
   Optional<T> read(ID id);
   void delete(T t);
}

