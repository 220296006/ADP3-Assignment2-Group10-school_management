/**AddressFactory.java
 * Factory for Address
 *Author: Daniella Burgess(219446482)
 * Date: 12 June 2022
 */

package za.ac.cput.factory;

import org.apache.commons.lang3.StringUtils;
import za.ac.cput.domain.Address;

public class AddressFactory {
    public static Address build(String unitNumber, String complexNumber, String streetNumber,
                                String streetName, int postalCode, Object city) {
        if (streetNumber == null || streetNumber.isEmpty())
            throw new IllegalArgumentException("Street number is required!");
        if (streetName == null || streetName.isEmpty())
            throw new IllegalArgumentException("Street name is required");
        if (postalCode <1000  || postalCode >9999)
            throw new IllegalArgumentException("Postal code invalid!");

        unitNumber = HelperClass.setEmptyIfNull(unitNumber);
        complexNumber = HelperClass.setEmptyIfNull(complexNumber);

        return new Address.Builder().unitNumber(unitNumber).complexNumber(complexNumber)
                .streetNumber(streetNumber).streetName(streetName).postalCode(postalCode).city(city)
                .build();
    }

    public static Address.AddressIdentity buildIdentity(Address address) {
        return new Address.AddressIdentity(address.getStreetNumber(),
                address.getStreetName());
    }
}
class HelperClass {
    private static boolean isEmptyOrNull(String str) {
        return StringUtils.isEmpty(str);
    }

    //unitNumber and complexNumber
    public static String setEmptyIfNull(String str) {
        if (isEmptyOrNull(str))
            return StringUtils.EMPTY;
        return str;
    }



}

