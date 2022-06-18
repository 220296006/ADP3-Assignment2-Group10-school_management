package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Employee;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,  String>{

   Optional<Employee> findEmployeeByEmail (String email);
}


