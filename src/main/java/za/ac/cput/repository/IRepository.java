/* IRepository.java
Repository Interface (CRUD)
 Author: Zaeem Petersen (219010145)
 Date: 13 June 2022
*/
package za.ac.cput.repository;

public interface IRepository<T,ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
