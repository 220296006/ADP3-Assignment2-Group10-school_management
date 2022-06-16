package za.ac.cput.service;
import java.util.Optional;

/* IService.java
 * Service Interface for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */
public interface IService<T, ID> {

    T save(T t);
    Optional<T> read(String id);
   void delete(T t);
}
