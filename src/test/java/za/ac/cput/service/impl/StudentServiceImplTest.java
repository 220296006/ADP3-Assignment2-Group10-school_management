package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.factory.StudentFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest {

    @Autowired
    private StudentServiceImpl studService;

    private final Name name = NameFactory.build("john", "", "Doe");
    private final Student student = StudentFactory.build("01","randomemail@gmail.com", name);


    @Order(1)
    @Test
    void save() {
        Student create = this.studService.save(this.student);
        assertEquals(this.student, create);
        System.out.println(create);
    }

    @Order(2)
    @Test
    void read() {
        Optional<Student> view = this.studService.read(this.student.getStudentId());
        assertAll(
                ()-> assertTrue(view.isPresent()),
                ()-> assertEquals(this.student,view.get())
        );
    }

    /*@Test
    void delete() {
       studService.delete(student);
        List<Student> studentList = this.studService.readAll();
        System.out.println(studentList);
    }*/

    @Order(4)
    @Test
    void deleteById() {
        studService.deleteById("2");
        List<Student> studentList = this.studService.readAll();
        System.out.println(studentList);
    }

    @Order(3)
    @Test
    void readAll() {
        List<Student> studentList = this.studService.readAll();
        assertEquals(1,studentList.size());
    }
    }
