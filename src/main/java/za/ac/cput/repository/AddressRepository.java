/**AddressRepository.java
 * Repository for Address
 * Author: Daniella Burgess 219446482
 * Date: 15 June 2022
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressRepository {
    private final List<Address> addressList;
    private static AddressRepository ADDRESS_REPOSITORY;

    private AddressRepository(){
        this.addressList = new ArrayList<>();
    }

    public static AddressRepository getRepository() {
        if (ADDRESS_REPOSITORY == null)
            ADDRESS_REPOSITORY = new AddressRepository();
        return ADDRESS_REPOSITORY;
    }

    public Address save(Address address) {
        Address.AddressIdentity addressIdentity =
                AddressFactory.buildIdentity(address);
        Optional<Address> read = read(addressIdentity);
        if (read.isPresent()) {
            delete(read.get());
        }
        this.addressList.add(address);
        return address;
    }

    public Optional<Address> read(Address.AddressIdentity addressIdentity) {
        return this.addressList.stream()
                .filter(g -> g.getStreetNumber().equalsIgnoreCase(addressIdentity.getStreetNumber()))
                .filter(g -> g.getStreetName().equalsIgnoreCase(addressIdentity.getStreetName()))
                .findFirst();
    }

    public void delete(Address address) {
        this.addressList.remove(address);
    }
}
