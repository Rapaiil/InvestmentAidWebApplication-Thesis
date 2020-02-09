package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {
	private static Properties properties = new Properties();
	private static InputStream inputStream;
	private static String email, password, key, uitf;
	
	private Configurations() {}
	
	private static class ConfigurationsHelper {
		private static final Configurations INSTANCE = new Configurations();
		
	}
	
	public static Configurations getInstance() {
		return ConfigurationsHelper.INSTANCE;
	}
	
	private void initializeConfigurations() throws IOException {
		inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		if(inputStream != null)
			properties.load(inputStream);
		else
			throw new FileNotFoundException("Property file \'config.properties\' not"
					+ " found in the classpath.");
		email = properties.getProperty("app_email");
		password = properties.getProperty("app_password");
		key = properties.getProperty("app_key");
		uitf = properties.getProperty("uitf_source");
	}
	
	private static void configure() throws IOException {
		getInstance().initializeConfigurations();
	}
	
	public static String getAppEmail() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return email;
	}
	
	public static String getAppPass() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return password;
	}
	
	public static String getAppSecret() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return key;
	}
	
	public static String getAppUitf() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return uitf;
	}
}
