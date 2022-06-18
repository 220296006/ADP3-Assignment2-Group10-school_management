/* EmployeeFactory.java
 Factory class for the Employee Domain
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.factory;

import lombok.experimental.Helper;
import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

public class EmployeeFactory {
    public static Employee build(String staffId, String email, Name name) {

        if (GenericHelper.isNullorEmpty(staffId))
            throw new IllegalArgumentException("staff Id is null or empty");
        if (GenericHelper.nameisNullorEmpty(name))
            throw new IllegalArgumentException("name is null or empty");
        if (!GenericHelper.emailIsValid(email))
            throw new IllegalArgumentException("email is invalid");

        return new Employee.Builder().staffId(staffId)
                .email(email)
                .name(name)
                .build();

    }
}

