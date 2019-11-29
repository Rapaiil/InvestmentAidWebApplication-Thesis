package invaid.users.util;

import java.util.Random;

public class TokenUtil {
	private StringBuffer identifier;
	final private char[] LETTER_VAULT = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'a', 'b', 'c', 'd', 'e', 'f', 'g'};
	private Random rand = new Random();
	
	public String getIdentifier() {
		setIdentifier(new StringBuffer());
		generate();
		return identifier.toString();
	}
	
	private void setIdentifier(StringBuffer identifier) {
		this.identifier = identifier;
	}
	
	private void generate() {
		for(int i=0; i < 7; i++) {
			setIdentifier(this.identifier.append(LETTER_VAULT[rand.nextInt(14)]));
		}
	}
	
}
