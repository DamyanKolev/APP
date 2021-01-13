package net.javaguides.springboot.security;

// ****************************** //
/* We use the HS256 algorithm in 
/ this example, so our secret key is 256 bits/32 chars.*/
// ****************************** //

public class SecurityConstants {
    public static final String SECRET = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 900_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
