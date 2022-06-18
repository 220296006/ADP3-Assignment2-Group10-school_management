/**AddressFactory.java
 * Factory for Address
 *Author: Daniella Burgess(219446482)
 * Date: 12 June 2022
 */

package za.ac.cput.factory;

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;

public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode, City city) {
        if (GenericHelper.isNullorEmpty(unitNumber) || GenericHelper.isNullorEmpty(complexName) || GenericHelper.isNullorEmpty(streetNumber)
                || GenericHelper.isNullorEmpty(streetName) || GenericHelper.isNullorEmpty(postalCode))
            throw new IllegalArgumentException("unitNumber, complexName, streetnumber, streetName or postalcode is null or empty");

        if (GenericHelper.cityisNullorEmpty(city))
            throw new IllegalArgumentException("city is null or Empty");

        if(!GenericHelper.isValidPostalCode(Integer.parseInt(postalCode)))
            throw new IllegalArgumentException("Postal code is invalid");

        return new Address.Builder().setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city).build();

    }
}


