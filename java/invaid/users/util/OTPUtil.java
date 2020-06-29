package invaid.users.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;

import javax.crypto.spec.SecretKeySpec;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;

import config.Configurations;

public class OTPUtil {
	private final static Duration OTP_DURATION = Duration.ofSeconds(30);
	private final static int PASSCODE_LENGTH = 6;
	private final static Instant NOW_TIME = Instant.now();
	
	public int generateOTP() {
		int passcode = 0;
		try {
			passcode = new TimeBasedOneTimePasswordGenerator(OTPUtil.OTP_DURATION,
						OTPUtil.PASSCODE_LENGTH,
						TimeBasedOneTimePasswordGenerator.TOTP_ALGORITHM_HMAC_SHA256).generateOneTimePassword(getKey(), OTPUtil.NOW_TIME);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch(InvalidKeyException ike) {
			ike.printStackTrace();
		}
		return passcode;
	}
	
	private static SecretKeySpec getKey() {
		byte[] key = Configurations.getAppSecret().getBytes();
		final SecretKeySpec secretKey = new SecretKeySpec(key, "HmacSHA256");
		return secretKey;
	}

}
