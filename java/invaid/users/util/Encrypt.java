package invaid.users.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Encrypt {
	public static char[] bcrypt(char[] plaintext) {
		return BCrypt.withDefaults().hashToChar(12, plaintext);
	}
}
