package za.ac.cput.Util;

public class Helper {

    public static boolean isValidString(String s){
        if(s == null)
            return false;
        if(s.trim().equals(""))
            return false;
        return true;
    }

    public static boolean isValidPostalCode(int code){
        return code > 1000 && code < 9999;
    }
}
