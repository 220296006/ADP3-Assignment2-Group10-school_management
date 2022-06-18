/* NameFactory.java
 Factory class for the Name Domain
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.factory;

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.Name;

public class NameFactory {

    public static Name build(String firstName, String middleName, String lastName) {

        if(GenericHelper.isNullorEmpty(firstName)|| GenericHelper.isNullorEmpty(lastName))
            throw new IllegalArgumentException("firstname or lastname is null or empty");
        middleName = GenericHelper.setEmptyIfNull(middleName);


        return new Name.Builder().firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();

    }
}
