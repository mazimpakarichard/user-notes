package rw.user.notes.config.security;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;


public class JwTokenUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9026799818179437303L;
	
public static final long JWT_VALIDITY = 3 * 60 * 60;

@Value("${jwt.secret}")
private String secret;

//retrieve Username from jwt token

public String getUsernameFromToke(String token) {
	return getClaimFromToken(token, Claims::getSubject);
}

//retrieve expiration date from jwt token

public Date getExpirationDateFromToken(String token) {
	return getClaimFromToken(token, Claims::getExpiration);
}
public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver) {
	final Claims claims = getAllClaimsFromToken(token);
	return claimsResolver.apply(claims);
}
//generate token for user

public String generateToken(UserDetails userDetails) {
	Map<String, Object> claims = new HashMap<>();
	return doGenerateToken(claims, userDetails.getUsername());
}
//validate token
public Boolean validateToken(String token, UserDetails userDetails) {
	final String username = getUsernameFromToken(token);
	return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}
}
