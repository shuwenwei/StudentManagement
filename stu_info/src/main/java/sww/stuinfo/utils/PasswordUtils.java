package sww.stuinfo.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtils {

    private static final String SALT = "ah13qf11399fa013a";

    private PasswordUtils(){
    }

    public static String generate(String password){
        String newPassword = DigestUtils.md5Hex(password);
        return DigestUtils.md5Hex(password + SALT);
    }

    public static boolean verify(String password, String md5){
        return md5.equals(generate(password));
    }

}
