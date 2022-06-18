package za.ac.cput.service.service;

import org.springframework.data.jpa.repository.Query;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends IService<Employee,String> {
    List<Employee> readAll();

    void deleteById(String id);


    Optional<Employee> findEmployeeByEmail(String email);



}
