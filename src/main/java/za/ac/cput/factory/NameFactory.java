/* NameFactory.java
 Factory class for the Name Domain
 Author: Zaeem Petersen (219010145)
 Date: 12 June 2022
*/
package za.ac.cput.factory;

import za.ac.cput.Util.ZaeemHelper;
import za.ac.cput.domain.Name;

public class NameFactory {
    public static Name build(String firstName, String middleName, String lastName)
    {
        if(firstName==null|| firstName.isEmpty())
            throw new IllegalArgumentException("first Name is required");
        if(middleName==null||middleName.isEmpty())
            throw new IllegalArgumentException("middle Name is required");
        if(lastName==null||lastName.isEmpty())
            throw new IllegalArgumentException("lastName is required");
        return new Name.Builder().firstName(firstName).middleName(middleName).lastName(lastName).build();
    }
    public static Name.NameId buildId(Name name){return new Name.NameId(name.getFirstName()); }
}


