package sww.stuinfo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sww.stuinfo.pojo.User;

import java.util.Date;

public class JWTUtils {

    private JWTUtils(){
    }

    private static final long EXPIRE_TIME = 2*60*60*1000;
    private static final String SECRET_KEY = "139uaj13a4ga-0139f1";

    public static String generateToken(User user){
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
                .setId(user.getUsername())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
    }

    public static String getUsername(String token){
        String username;
        try {
            username = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }catch (RuntimeException e){
            return null;
        }
        return username;
    }

}
