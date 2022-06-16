package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.repository.EmployeeAddressRepository;
import za.ac.cput.service.service.EmployeeAddressService;

import java.util.List;
import java.util.Optional;


@Service //creates a bin allows you to have singletons for whatever class you want to implement
public class EmployeeAddressServiceImpl implements EmployeeAddressService {
    private final EmployeeAddressRepository  repository;

    @Autowired public EmployeeAddressServiceImpl(EmployeeAddressRepository repository)
    {

        this.repository=repository;
    }
    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {

        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(EmployeeAddress.EmployeeAddressId employeeAddressId) {
        return this.repository.findById(employeeAddressId);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> findAll(){return this.repository.findAll();}

    /* @Override
     public void deleteById(String id)
     {
         Optional<EmployeeAddress> addressType=read(id);
         if(addressType.isPresent()) delete(addressType.get());

     }*/
    @Override
    public List findByStaffId(String staffId)
    {
        return this.repository.findByStaffId(staffId);

    }
}
