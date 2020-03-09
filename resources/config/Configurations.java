package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {
	private static Properties properties = new Properties();
	private static InputStream inputStream;
	private static String email, password, key, bankUitf, fundUitf, bankMf, fundMf, ext;
	
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
		bankUitf = properties.getProperty("uitf_bank_source");
		fundUitf = properties.getProperty("uitf_fund_source");
		bankMf = properties.getProperty("mf_bank_source");
		fundMf = properties.getProperty("mf_fund_source");
		ext = properties.getProperty("uitf_ext");
		
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
	
	public static String getAppBankUitf() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return bankUitf;
	}
	
	public static String getAppFundUitf() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return fundUitf;
	}
	
	public static String getAppBankMf() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return bankMf;
	}
	
	public static String getAppFundMf() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return fundMf;
	}
	
	public static String getAppUitfExt() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return ext;
	}
}
