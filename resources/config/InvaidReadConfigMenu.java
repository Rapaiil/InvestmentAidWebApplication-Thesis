package config;

import java.io.IOException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class InvaidReadConfigMenu {

	public static void main(String[] args) throws IOException {
		InvaidGetPropertyValues properties = new InvaidGetPropertyValues();
		System.out.println(properties.getPropValues());
		System.out.println("\nProgram executed on " + properties.getDateInitiated());
		
		Algorithm algorithm = Algorithm.HMAC256(properties.getKey());
		String jws = null;
		try {
			jws = JWT.create()
						.withIssuer(properties.getIssuer())
						.withIssuedAt(new Date(properties.getDateInitiated()))
						.sign(algorithm);
		} catch(JWTCreationException jwtce) {
			System.err.println(jwtce.getMessage());
		}
		
		System.out.println(jws);
	}

}
