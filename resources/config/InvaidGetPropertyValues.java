package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InvaidGetPropertyValues {
	private long dateInitiated;
	private String key;
	private StringBuffer email;
	private StringBuffer result;
	private InputStream inputStream;
	
	public String getPropValues() throws IOException {
		try {
			Properties prop = new Properties();
			StringBuffer propFileName = new StringBuffer("config.properties");
			
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName.toString());
			
			if(inputStream != null)
				prop.load(inputStream);
			else
				throw new FileNotFoundException("Property file \'" + propFileName.toString() + "\' not"
						+ " found in the classpath.");
			
			dateInitiated = System.currentTimeMillis();
			email = new StringBuffer(prop.getProperty("app_email"));
			key = prop.getProperty("app_key");
			result = new StringBuffer("Email=" + prop.getProperty("app_email") + ",password=" + prop.getProperty("app_password"));
		} catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			inputStream.close();
		}
		
		return result.toString();
	}

	public String getKey() {
		return key;
	}
	public long getDateInitiated() {
		return dateInitiated;
	}
	
	public String getIssuer() {
		return this.email.toString();
	}
	
}
