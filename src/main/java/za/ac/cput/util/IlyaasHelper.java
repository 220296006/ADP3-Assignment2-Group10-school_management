package za.ac.cput.util;

import java.util.UUID;

public class IlyaasHelper {
    public static boolean isNullorEmpty(String s) {
        return (s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static String GenerateId() {
        return UUID.randomUUID().toString();
    }
}
