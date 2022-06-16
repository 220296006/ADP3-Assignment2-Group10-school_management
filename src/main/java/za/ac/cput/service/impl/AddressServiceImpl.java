package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.service.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    @Autowired
    public AddressServiceImpl(AddressRepository repository)
    {
        this.repository=repository;
    }
    @Override
    public Address save(Address address){return this.repository.save(address);}

    @Override
    public Optional<Address> read(Address.AddressId addressId)
    {
        return this.repository.findById(addressId);
    }
    @Override
    public void delete(Address address){this.repository.delete(address);}
    @Override
    public List<Address> findAll(){return this.repository.findAll();}
    /*@Override
    public void deleteById(String id)
    {
    Optional<Address>address=read(id);
    if(address.isPresent()) delete(employee.get());
    }
     */
    @Override
    public List findByUnitNumber(String unitNumber){return this.repository.findByUnitNumber(unitNumber);}
}



