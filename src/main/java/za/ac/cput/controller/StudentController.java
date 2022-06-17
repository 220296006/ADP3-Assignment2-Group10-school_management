package za.ac.cput.controller;

/*Waseem Dollie - 216040566*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Student;
import za.ac.cput.service.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/student/")
@Slf4j
public class StudentController {
    public final StudentService studentService;

    @Autowired public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping("save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student)
    {
        log.info("save request:{}",student);
        Student save=studentService.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<Student> read(@PathVariable Student.StudentId studentId)
    {
        log.info("Read request:{}",studentId);
        Student student=this.studentService.read(studentId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<Student>delete(@PathVariable Student student)
    {
        log.info("Read request:{}",student);
        this.studentService.delete(student);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Student>>findAll()
    {
        List<Student>studentList=this.studentService.findAll();
        return ResponseEntity.ok(studentList);
    }
}

