package books.catalog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

public class JwtGenerator {

    //private static final long EXPIRATION_TIME = 3600000; // 1 hour in milliseconds
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate a secure key

    public static String generateSessionId() {
        UUID uuid = UUID.randomUUID(); // Generates a random UUID
        return uuid.toString(); // Converts UUID to string
    }

    // Method to generate JWT
    public static String generateJwt(String sessionId) {
        return Jwts.builder()
                .setSubject(sessionId)  // You can set any claim, e.g., sessionId or user info
                .setIssuedAt(new Date()) // Issue date
                //.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Expiry time
                .signWith(SECRET_KEY)  // Use HS256 algorithm with secret key
                .compact();
    }

    // Method to parse JWT and extract the session ID
    public static String getSessionIdFromJwt(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()  // Build the JwtParser
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();  // Return the session ID from the JWT
    }

    public static void main(String[] args) {
        // Generate JWT with a session ID
        String sessionId = generateSessionId();  // This can be any identifier
        String jwt = generateJwt(sessionId);
        
        System.out.println("Generated JWT: " + jwt);

        // Extract the session ID from the JWT
        String extractedSessionId = getSessionIdFromJwt(jwt);
        System.out.println("Extracted Session ID: " + extractedSessionId);
    }
}