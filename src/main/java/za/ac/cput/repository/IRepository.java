/**IRepository.java
 * Interface for Repository
 * Author: Daniella Burgess 219446482
 * Date: 15 June 2022
 */

package za.ac.cput.repository;

import java.util.Optional;

public interface IRepository<T, ID> {
    T save(T t);

    Optional<T> read(ID id);

    void delete(T t);
}