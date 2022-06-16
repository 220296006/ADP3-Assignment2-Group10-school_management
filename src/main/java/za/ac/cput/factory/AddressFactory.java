/**AddressFactory.java
 * Factory for Address
 *Author: Daniella Burgess(219446482)
 * Date: 12 June 2022
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Address;

public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode)
    {
        if(unitNumber==null || unitNumber.isEmpty())
            throw new IllegalArgumentException("unitNumber is required");
        if(complexName==null||complexName.isEmpty())
            throw new IllegalArgumentException("complexName is required");
        if(streetNumber==null||streetNumber.isEmpty())
            throw new IllegalArgumentException("streetNumber is required");
        if(streetName==null|| streetName.isEmpty())
            throw new IllegalArgumentException("streetName is required");
        if(postalCode==null||postalCode.isEmpty())
            throw new IllegalArgumentException("postal code is required");
        return new Address.Builder().unitNumber(unitNumber).complexName(complexName).streetNumber(streetNumber).streetName(streetName).postalCode(postalCode).build();
    }
    public static Address.AddressId buildId(Address address)
    {
        return new Address.AddressId(address.getUnitNumber());
    }
}


