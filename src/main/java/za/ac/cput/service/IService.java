/**IService.java
 * Interface for Service
 * Author: Daniella Burgess 219446482
 * Date: 15 June 2022
 */

package za.ac.cput.service;

import za.ac.cput.domain.Address;
import java.util.Optional;

public interface IService <T, ID> {
    T save(T t);
    Optional<T> read(Address.AddressIdentity id);
    void delete(T t);
}
