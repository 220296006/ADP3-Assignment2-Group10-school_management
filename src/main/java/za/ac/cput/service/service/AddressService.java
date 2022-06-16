package za.ac.cput.service.service;

import za.ac.cput.domain.Address;
import za.ac.cput.service.IService;

import java.util.List;

public interface AddressService extends IService<Address,Address.AddressId> {
    List<Address> findAll();
    //void deleteById(String id);
    List<Address>findByUnitNumber(String unitNumber);
}
