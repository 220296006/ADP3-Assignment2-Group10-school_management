package za.ac.cput.service;

import za.ac.cput.domain.Address;

import java.util.Optional;

public interface AddressService extends IService<Address, Address.AddressIdentity>{
    Optional<Address> read(Address.AddressIdentity addressIdentity);
}

