package za.ac.cput.service.impl;

/*Waseem Dollie - 216040566*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.repository.IStudentAddressRepository;
import za.ac.cput.service.service.StudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {

    private final IStudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(IStudentAddressRepository repository)
    {
        this.repository=repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);

    }

    @Override
    public List<StudentAddress> readAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<StudentAddress> studentAddr = read(id);
        studentAddr.ifPresent(this::delete);
    }
}
