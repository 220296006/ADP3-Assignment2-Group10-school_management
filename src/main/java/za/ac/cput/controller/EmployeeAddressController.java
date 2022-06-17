package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.service.service.EmployeeAddressService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/employee-address/")
@Slf4j
public class EmployeeAddressController {
    public final EmployeeAddressService employeeAddressService;

    @Autowired public EmployeeAddressController(EmployeeAddressService employeeAddressService)
    {
        this.employeeAddressService=employeeAddressService;
    }
    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress employeeAddress)
    {
        log.info("save request:{}",employeeAddress);
        EmployeeAddress save=employeeAddressService.save(employeeAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable EmployeeAddress.EmployeeAddressId employeeAddressId)
    {
        log.info("Read request:{}",employeeAddressId);
        EmployeeAddress employeeAddress=this.employeeAddressService.read(employeeAddressId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }
    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<EmployeeAddress>delete(@PathVariable EmployeeAddress employeeAddress)
    {
        log.info("Read request:{}",employeeAddress);
        this.employeeAddressService.delete(employeeAddress);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>>findAll()
    {
        List<EmployeeAddress>employeeAddressList=this.employeeAddressService.findAll();
        return ResponseEntity.ok(employeeAddressList);
    }
}