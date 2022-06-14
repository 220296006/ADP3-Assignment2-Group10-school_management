package za.ac.cput.service;
/* IService.java
 * Service Interface for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */
public interface IService<T, ID> {

    T save(T t);
    T read(ID id);
   void delete(ID id);
}
