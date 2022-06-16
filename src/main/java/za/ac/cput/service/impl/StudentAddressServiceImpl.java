package za.ac.cput.service.impl;

/*Waseem Dollie - 216040566*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.repository.StudentAddressRepository;
import za.ac.cput.service.service.StudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {
    private final StudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(StudentAddressRepository repository)
    {
        this.repository=repository;
    }
    @Override
    public StudentAddress save(StudentAddress studentAddress) {

        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(StudentAddress.StudentAddressId studentAddressId){return this.repository.findById(studentAddressId);}

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);
    }

    @Override
    public List<StudentAddress> findAll(){return this.repository.findAll();}


    /*@Override
    public void deleteById(String id)
    {
        Optional<StudentAddress> addressType=read(id);
        if(addressType.isPresent()) delete(addressType.get());

    }*/


    @Override
    public List findByStudentId(String studentId)
    {
        return this.repository.findByStudentId(studentId);

    }
}
