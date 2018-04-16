package br.com.ehrm.config;

import java.util.Properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import br.com.ehrm.utils.FileUtil;

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
