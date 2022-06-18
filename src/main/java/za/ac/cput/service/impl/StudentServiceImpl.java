package za.ac.cput.service.impl;

/*Waseem Dollie - 216040566*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.IStudentRepository;
import za.ac.cput.service.service.StudentService;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

    private final IStudentRepository repository;

    @Autowired
    public StudentServiceImpl(IStudentRepository repository)
    {
        this.repository=repository;
    }

    @Override
    public Student save(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Optional<Student> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Student student) {
        this.repository.delete(student);
    }

    @Override
    public void deleteById(String id) {
        Optional<Student> student = read(id);
        student.ifPresent(this::delete);
    }

    @Override
    public List<Student> readAll() {
        return this.repository.findAll();
    }
}