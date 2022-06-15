package za.ac.cput.service.impl;

/*Waseem Dollie - 216040566*/

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;
import za.ac.cput.service.service.StudentService;


import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    public final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository)
    {
        this.repository=repository;
    }
    @Override
    public Student save(Student student)
    {
        return this.repository.save(student);
    }
    @Override
    public Optional<Student> read(Student.StudentId studentId){return this.repository.findById(studentId);}

    @Override
    public void delete(Student student){this.repository.delete(student);}
    @Override
    public List<Student> findAll(){return this.repository.findAll();}

    /*
    @Override
    public void deleteById(String id)
    {
        Optional<Student>student=read(id);
        if(student.isPresent())delete(student.get());
    }

     */

    @Override
    public List findByStudentId(String studentId)
    {
        return this.repository.findByStudentId(studentId);
    }
}