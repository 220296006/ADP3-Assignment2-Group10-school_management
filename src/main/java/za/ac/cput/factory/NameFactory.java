/* NameFactory.java
 Factory class for the Name Domain
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.factory;

import za.ac.cput.Util.ZaeemHelper;
import za.ac.cput.domain.Name;

public class NameFactory {

    public static Name createName(String firstName, String middleName, String lastName){

        //insert the Helper class here
        if (ZaeemHelper.isNull(firstName) || ZaeemHelper.isNull(middleName) || ZaeemHelper.isNull(lastName)){
            return null;
        }

        return new Name.Builder().setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
    }
}
