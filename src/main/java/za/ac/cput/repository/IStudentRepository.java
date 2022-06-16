package za.ac.cput.repository;

/*Waseem Dollie - 216040566*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Student;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Student.StudentId> {
    List<Student> findAll();
    List<Student>findByStudentId(String studentId);
}
