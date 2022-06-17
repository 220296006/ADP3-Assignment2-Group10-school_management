package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.service.StudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest {

    private final Student student = StudentFactory.build("003", "email@gmail.com");
    private Student.StudentId studentId=StudentFactory.buildId(this.student);

    @Autowired
    private StudentService Stuservice;

    @Order(1)
    @Test
    void save() {
        Student create = this.Stuservice.save(this.student);
        assertAll(
                ()->assertNotNull(create),
                ()->assertEquals(this.student,create)
        );
    }
    @Order(2)
    @Test
    void read() {
        Optional<Student> view = this.Stuservice.read(this.studentId);
        System.out.println(view);
        assertAll(
                ()->assertTrue(view.isPresent()),
                ()->assertEquals(this.student,view.get())
        );
    }
    @Order(4)
    @Test
    void delete() {
        this.Stuservice.delete(this.student);
    }

    @Order(5)
    @Test
    void findAll() {
        List<Student> studentList=this.Stuservice.findAll();
        assertEquals(0,studentList.size());
    }
    @Order(3)
    @Test
    void findByStudentId() {
        String studentId = this.studentId.getStudentId();
        List<Student>studentList = this.Stuservice.findByStudentId(studentId);
        System.out.println(studentList);
        assertSame(1,studentList.size());
    }
}