/* EmployeeRepository.java
 Employee Repository class
 Author: Zaeem Petersen (219010145)
 Date: 14 June 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository implements IEmployeeRepository {
    private static EmployeeRepository repository = null;
    private Set<Employee> employeeDB = null;

    private EmployeeRepository(){
        employeeDB = new HashSet<Employee>();
    }

    //declare singleton
    public static EmployeeRepository getRepository(){
        if(repository == null){
            repository = new EmployeeRepository();
        }
        return repository;
    }

    //CRUD

    @Override
    public Employee create(Employee employee) {
        boolean success = employeeDB.add(employee);
        if(!success)
        return null;
        return employee;
    }

    @Override
    public Employee read(String staffId) {
        for (Employee e : employeeDB) {
            if (e.getStaffId() == staffId)
                return e;
        }
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        Employee oldEmployee = read(employee.getStaffId());
        if(oldEmployee != null){
            employeeDB.remove(oldEmployee);
            employeeDB.add(employee);
            return employee;
        }
        else
        return null;
    }

    @Override
    public boolean delete(String staffID) {
        Employee employeeDelete = read(staffID);
        if(employeeDelete == null){
            return false;
        }
        else
            employeeDB.remove(employeeDelete);
            return true;

    }

    @Override
    public Set<Employee> getAll() {
        return employeeDB;
    }
}
