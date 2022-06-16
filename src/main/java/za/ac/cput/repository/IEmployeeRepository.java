package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;

import java.util.List;
import java.util.Set;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Employee.EmployeeId>{

    List<Employee> findAll();
    List<Employee>findByStaffId(String staffId);
   // @Query("select e.name.firstName from Employee e where e.email = :email")
    //List<String> findByEmail(@Param(value = "email") String email);
}


