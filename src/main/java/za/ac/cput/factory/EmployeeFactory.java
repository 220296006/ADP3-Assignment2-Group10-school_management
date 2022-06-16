/* EmployeeFactory.java
 Factory class for the Employee Domain
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.factory;

import za.ac.cput.Util.ZaeemHelper;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

public class EmployeeFactory {

    public static Employee createEmployee(String staffId, String email, Name name){


        //insert the Helper here
        String help = ZaeemHelper.GenerateId();

        if(ZaeemHelper.isNullorEmpty(staffId)|| ZaeemHelper.isNullorEmpty(String.valueOf(name))){
            return null;
        }

        if(!ZaeemHelper.isValid(email)){
            return null;
        }

        return new Employee.Builder().setStaffId(staffId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}
