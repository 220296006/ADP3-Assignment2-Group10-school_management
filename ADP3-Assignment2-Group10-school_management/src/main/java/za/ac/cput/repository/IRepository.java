package za.ac.cput.repository;
/* IRepository.java
 * Repository Interface for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 12 June 2022
 */
public interface IRepository<T, ID>{

    T save(T t);
    T read(ID id);
   boolean delete(ID id);
}

