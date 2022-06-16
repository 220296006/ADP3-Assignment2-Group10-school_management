/* EmployeeFactory.java
 Factory class for the Employee Domain
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.factory;

import za.ac.cput.Util.StringHelper;
import za.ac.cput.Util.ZaeemHelper;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

public class EmployeeFactory {
    public static Employee build(String staffId,String email)
    {
        if(staffId ==null ||staffId.isEmpty() )
            throw new IllegalArgumentException("staffId is required!");
        if( email ==null||email.isEmpty() )
            throw new IllegalArgumentException("email is required!");
        return new Employee.Builder().staffId(staffId)
                .email(email).build();

    }
    public static Employee.EmployeeId buildId(Employee employee)
    {
        return new Employee.EmployeeId(employee.getStaffId());
    }

    public static Employee createEmployee(String email,String staffId) {
        if (!StringHelper.isValidEmail(email))
        {
            System.out.println("Not a valid email");
            return null;
        }
        if (StringHelper.isNullorEmpty(staffId)||StringHelper.isNullorEmpty(email))
            return null;


        return null;
    }}

