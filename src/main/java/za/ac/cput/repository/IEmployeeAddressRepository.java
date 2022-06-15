package za.ac.cput.repository;
import za.ac.cput.domain.EmployeeAddress;

import java.util.List;

public interface IEmployeeAddressRepository extends IRepository<EmployeeAddress,String> {
    public List<EmployeeAddress> getAll();
}
