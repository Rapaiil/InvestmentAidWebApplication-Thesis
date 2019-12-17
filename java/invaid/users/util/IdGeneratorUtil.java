package invaid.users.util;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class IdGeneratorUtil {
	public static String generateId(String value1, String value2) throws UnsupportedEncodingException {
		String source = value1 + value2 + System.currentTimeMillis();
		return UUID.nameUUIDFromBytes(source.getBytes("UTF-8")).toString();
	}

}
