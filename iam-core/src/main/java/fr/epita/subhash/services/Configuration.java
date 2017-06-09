/**
 * 
 */
package fr.epita.subhash.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author subhash
 *
 */
public class Configuration {
	
	
	private static Configuration instance;
	
	private String jdbcConnectionString;
	private String user;
	private String pwd;
	
	private Properties props;
	
	
	/**
	 * 
	 */
	private Configuration() {
		InputStream input = null;
		try {
			input = new FileInputStream("core.properties");
			props.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Configuration getInstance(){
		if (instance == null){
			instance = new Configuration();
		}
		return instance;
	}
	
	/**
	 * @return the jdbcConnectionString
	 */
	public String getJdbcConnectionString() {
		return props.getProperty("jdbc.connection.string");
	}


	/**
	 * @return the user
	 */
	public String getUser() {
		return props.getProperty("jdbc.connection.user");
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return props.getProperty("jdbc.connection.pwd");
	}
	


}
