package za.ac.cput.factory;

import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.util.IlyaasHelper;

public class EmployeeAddressFactory {

    public static EmployeeAddress createEmployeeAddress (String staffId , String Address) {
        String stID = IlyaasHelper.GenerateId();
        if (IlyaasHelper.isNullorEmpty(stID) || IlyaasHelper.isNullorEmpty(Address)) {
            return null;
        }

        EmployeeAddress employeeAddress = new EmployeeAddress.Builder().setStaffId(stID).setAddress(Address).build();
        return employeeAddress;
    }

}
