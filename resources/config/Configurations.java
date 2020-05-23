package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {
	private static Properties properties = new Properties();
	private static InputStream inputStream;
	private static String emailMain, emailFeedback, password, key, bankUitf, fundUitf, bankMf, fundMf, ext, mfFile, uitfFile, forex, forexFile;
	
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
		emailMain = properties.getProperty("app_email_main");
		emailFeedback = properties.getProperty("app_email_feedback");
		password = properties.getProperty("app_password");
		key = properties.getProperty("app_key");
		bankUitf = properties.getProperty("uitf_bank_source");
		fundUitf = properties.getProperty("uitf_fund_source");
		bankMf = properties.getProperty("mf_bank_source");
		fundMf = properties.getProperty("mf_fund_source");
		ext = properties.getProperty("uitf_ext");
		mfFile = properties.getProperty("mf_xml");
		uitfFile = properties.getProperty("uitf_xml");
		forex = properties.getProperty("forex_source");
		forexFile = properties.getProperty("forex_xml");
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
		return emailMain;
	}
	
	public static String getAppFeedback() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return emailFeedback;
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
	
	public static String getMfFile() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return mfFile;
	}
	
	public static String getUitfFile() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return uitfFile;
	}
	
	public static String getForexSource() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return forex;
	}
	
	public static String getForexFile() {
		try {
			configure();
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return forexFile;
	}
}
