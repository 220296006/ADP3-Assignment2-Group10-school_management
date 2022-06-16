package za.ac.cput.Util;

import java.util.UUID;

public class ZaeemHelper {
    public static boolean isNullorEmpty(String s) {
        return (s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static String GenerateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isNull(String q){
        return (q==null || q.equals("") || q.isEmpty());

    }
}
