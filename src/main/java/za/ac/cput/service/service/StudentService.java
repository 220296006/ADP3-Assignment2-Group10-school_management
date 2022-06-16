package za.ac.cput.service.service;

/*Waseem Dollie - 216040566*/

import za.ac.cput.domain.Student;
import za.ac.cput.service.IService;

import java.util.List;

public interface StudentService extends IService<Student,Student.StudentId> {
    List<Student> findAll();
    //void deleteById(String id);
    List<Student> findByStudentId(String studentId);
}
