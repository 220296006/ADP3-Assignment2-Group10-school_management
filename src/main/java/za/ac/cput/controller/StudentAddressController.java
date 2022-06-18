package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.service.service.StudentAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/studentAddress/")
@Slf4j
public class StudentAddressController {
    public final StudentAddressService studentAddressService;

    @Autowired public StudentAddressController(StudentAddressService studentAddressService)
    {
        this.studentAddressService=studentAddressService;
    }
    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress)
    {
        log.info("save request:{}",studentAddress);
        StudentAddress save=studentAddressService.save(studentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<StudentAddress> read(@PathVariable String studentAddressId)
    {
        log.info("Read request:{}",studentAddressId);
        StudentAddress studentAddress=this.studentAddressService.read(studentAddressId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }
    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<StudentAddress>delete(@PathVariable String studentAddressId)
    {
        log.info("Read request:{}",studentAddressId);
        this.studentAddressService.deleteById(studentAddressId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>>findAll()
    {
        List<StudentAddress>studentAddressList=this.studentAddressService.readAll();
        return ResponseEntity.ok(studentAddressList);
    }
}

