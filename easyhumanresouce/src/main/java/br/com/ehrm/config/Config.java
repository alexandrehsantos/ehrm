package br.com.ehrm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class Config.
 */

@Component
public class Config {

	@Autowired
	private Environment env;

	public String getJDBCUrl() {
		return env.getProperty("jdbc.url");
	}

	public String getJDBCDriver() {
		return env.getProperty("jdbc.driver");
	}

	public String getJDBCUser() {
		return env.getProperty("jdbc.user");
	}

	public String getJDBCPassword() {
		return env.getProperty("jdbc.pass");
	}

}
