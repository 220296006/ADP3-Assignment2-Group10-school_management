package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.IEmployeeAddressRepository;
import za.ac.cput.service.service.EmployeeAddressService;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private final IEmployeeAddressRepository  repository;

    @Autowired public EmployeeAddressServiceImpl(IEmployeeAddressRepository repository)
    {

        this.repository=repository;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> readAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<EmployeeAddress> employeeAddress = read(id);
        employeeAddress.ifPresent(this::delete);
    }
}
