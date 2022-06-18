package za.ac.cput.Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.Name;

import java.util.UUID;

public class GenericHelper {

        //checks if string is null or empty (returns true if condition is met)
        public static boolean isNullorEmpty(String s) {
            return (s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
        }

        public static boolean nameisNullorEmpty(Name name){
            return name == null;
        }

        public static boolean addressisNullorEmpty(Address address)
        {
            return address == null;
        }

        public static boolean cityisNullorEmpty(City city){
        return city == null;
    }

        public static boolean isValidPostalCode(int code){return code > 1000 && code < 9999;}

        //checks that emails are valid
        public static boolean emailIsValid(String email){
            EmailValidator valid = EmailValidator.getInstance();
            return valid.isValid(email);
        }

        //returns null if string empty
        public static String setEmptyIfNull(String rNull){
            if (isNullorEmpty(rNull)){
                return StringUtils.EMPTY;
            }
            return rNull;
        }

}


