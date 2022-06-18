package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.service.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final IEmployeeRepository repository;

    @Autowired public EmployeeServiceImpl(IEmployeeRepository repository)
    {
        this.repository=repository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);
    }

    @Override
    public List<Employee> readAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Employee> employee = read(id);
        employee.ifPresent(this::delete);
        }

    }


