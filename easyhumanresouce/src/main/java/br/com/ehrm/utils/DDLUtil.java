package br.com.ehrm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ehrm.config.Config;
import br.com.ehrm.exception.EhrmException;

// TODO: Auto-generated Javadoc
/**
 * The Class DDLUtil.
 */
@Repository
public class DDLUtil {

	private static final String DEFAULT_USER_DATABASE = "sa";

	private static final String ORG_H2_DRIVER = "org.h2.Driver";

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(DDLUtil.class);

	/** The config. */
	@Autowired
	private Config config;

	/**
	 * Teste.
	 *
	 * @param databaseName
	 *            the database name
	 */
	public void teste(String databaseName) {
		System.out.println("DataBaseName" + databaseName);
		System.out.println("Jdbc Driver" + config.getJDBCDriver());
		System.out.println("Jdbc Url" + config.getJDBCUrl());
		System.out.println("Jdbc User" + config.getJDBCUser());
		System.out.println("Jdbc Password" + config.getJDBCPassword());
	}

	/**
	 * Creates the data base.
	 *
	 * @param databaseName
	 *            the database name
	 */
	public void createDataBase(String databaseName) {
		Connection connObj = null;
		Statement stmtObj = null;

		try {
			Class.forName(config.getJDBCDriver());
			connObj = DriverManager.getConnection(config.getJDBCUrl() + ":" + databaseName, config.getJDBCUser(),
					config.getJDBCPassword());
			stmtObj = connObj.createStatement();

			LOGGER.info("\n=====CREATE " + databaseName + " DATABASE======");
			stmtObj.executeUpdate(DBConstants.getScriptTables());

			createDataSourceConfig(databaseName);

		} catch (ClassNotFoundException | SQLException e) {
			String msgError = e.getMessage();
			LOGGER.error(msgError, e);
			throw new EhrmException(msgError, e);

		}

	}

	/**
	 * Creates the data source config.
	 *
	 * @param databaseName
	 *            the database name
	 */
	private void createDataSourceConfig(String databaseName) {
//		DataSourceConfig newDataSource = new DataSourceConfig();
//		newDataSource.setName(databaseName);
//		newDataSource.setDriverClassName(ORG_H2_DRIVER);
//		newDataSource.setUrl(config.getJDBCUrl() + ":" + databaseName);
//		newDataSource.setUsername(DEFAULT_USER_DATABASE);
//		newDataSource.setPassword("");
//		newDataSource.setInitialize(true);

//		configRepo.save(newDataSource);
	}

}
