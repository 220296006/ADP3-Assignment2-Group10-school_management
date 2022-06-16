package za.ac.cput.service.impl;

import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.service.service.IEmployeeAddressServices;

import java.util.ArrayList;

public class EmployeeAddressServices implements IEmployeeAddressServices {
     private final EmployeeAddressRepository repository;
     private static  IEmployeeAddressServices SERVICES;

     private EmployeeAddressServices(){
         this.repository = EmployeeAddressRepository.getRepository();
     }

     public static IEmployeeAddressServices getServices() {
         if (SERVICES == null) {
            SERVICES = new EmployeeAddressServices();
         }
         return SERVICES;
     }

    @Override
    public ArrayList<EmployeeAddress> getAll() {
        return this.repository.getAll();
    }

    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress) {
        return this.repository.create(employeeAddress);
    }

    @Override
    public EmployeeAddress read(String staffId) {
        return this.repository.read(staffId);
    }

    @Override
    public EmployeeAddress update(EmployeeAddress employeeAddress) {
        return this.repository.update(employeeAddress);
    }

    @Override
    public boolean delete(String staffId) {
        return this.repository.delete(staffId);
    }
}
