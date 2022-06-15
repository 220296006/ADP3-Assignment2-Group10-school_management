/**AddressServiceImp.java
 * Service for Address
 * Author: Daniella Burgess 219446482
 * Date: 15 June 2022
 */

package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.Optional;

public class AddressServiceImp implements AddressService{
    private final AddressRepository repository;
    private static AddressServiceImp SERVICE;

    private AddressServiceImp(){
        this.repository= AddressRepository.getRepository();
    }

    public static AddressServiceImp getService() {
        if (SERVICE == null)
            SERVICE = new AddressServiceImp();
        return SERVICE;
    }

    @Override
    public Address save(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Optional<Address> read(Address.AddressIdentity addressIdentity) {
        return this.repository.read(addressIdentity);
    }

    @Override
    public void delete(Address address) {
        this.repository.delete(address);
    }
}
