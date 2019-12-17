package invaid.users.util;

import java.sql.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import config.Configurations;

public class TokenUtil {
	private static String TOKEN_IDENTIFIER;
	
	/**
	 * Generates unverified unique token for user in specified time with 1 hour expiry date
	 */
	public static String generateUnverifiedToken(String value1, String value2) {
		Date created = new Date(System.currentTimeMillis());
		Date expired = new Date(System.currentTimeMillis() + (60 * 60 * 1000));
		Algorithm algo = Algorithm.HMAC256(Configurations.getAppSecret());
		TOKEN_IDENTIFIER = JWT.create()
				.withIssuer("invaid.com")
				.withSubject(value1 + " " + value2)
				.withClaim("isVerified", false)
				.withIssuedAt(created)
				.withExpiresAt(expired)
				.sign(algo);
		return TOKEN_IDENTIFIER;
	}
	
	/**
	 * Generates verified unique token for user in specified time with 1 hour expiry date
	 */
	public static String generateVerifiedToken(String value1, String value2) {
		Date created = new Date(System.currentTimeMillis());
		Date expired = new Date(System.currentTimeMillis() + (60 * 60 * 1000));
		Algorithm algo = Algorithm.HMAC256(Configurations.getAppSecret());
		TOKEN_IDENTIFIER = JWT.create()
				.withIssuer("invaid.com")
				.withSubject(value1 + " " + value2)
				.withClaim("isVerified", true)
				.withIssuedAt(created)
				.withExpiresAt(expired)
				.sign(algo);
		return TOKEN_IDENTIFIER;
	}
	
	/**
	 * Generates default reset token for user request on refresh tokens
	 */
	public static String sendResetToken() {
		Algorithm algo = Algorithm.HMAC256(Configurations.getAppSecret());
		TOKEN_IDENTIFIER = JWT.create()
				.withIssuer("invaid.com")
				.withSubject("default")
				.withIssuedAt(new Date(System.currentTimeMillis()))
				.sign(algo);
		return TOKEN_IDENTIFIER;
	}
	
	public static DecodedJWT decodeToken(String TOKEN_IDENTIFIER) throws JWTDecodeException {
		return JWT.decode(TOKEN_IDENTIFIER);
	}
	
	public static JWTVerifier verifyResetToken() {
		Algorithm algo = Algorithm.HMAC256(Configurations.getAppSecret());
		JWTVerifier verifier = JWT.require(algo)
				.withIssuer("invaid.com")
				.withSubject("default")
				.ignoreIssuedAt()
				.build();
		return verifier;
	}
	
	public static JWTVerifier verifyUserVerifiedToken() {
		Algorithm algo = Algorithm.HMAC256(Configurations.getAppSecret());
		JWTVerifier verifier = JWT.require(algo)
				.withIssuer("invaid.com")
				.withClaim("isVerified", true)
				.build();
		return verifier;
	}
	
	public static JWTVerifier verifyUserUnverifiedToken() {
		Algorithm algo = Algorithm.HMAC256(Configurations.getAppSecret());
		JWTVerifier verifier = JWT.require(algo)
				.withIssuer("invaid.com")
				.withClaim("isVerified", false)
				.build();
		return verifier;
	}

	/**
	 * 1 hour expiration:
	 * -> verification
	 * -> forgot password
	 * 
	 * JSessionID expiry: 5 mins idle time
	 * 
	 * Status for User accounts
	 * -> in List
	 * -> 1st parameter, 0 (unverified) and 1 (verified)
	 * -> 2nd parameter, 0 (neutral) and 1 (forgot password)
	 */
	
}
