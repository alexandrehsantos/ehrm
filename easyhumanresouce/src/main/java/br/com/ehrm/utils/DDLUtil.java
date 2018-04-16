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

@Repository
public class DDLUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(DDLUtil.class);

	@Autowired
	private Config config;

	public void teste(String databaseName) {
		System.out.println("DataBaseName" + databaseName);
		System.out.println("Jdbc Driver" + config.getJDBCDriver());
		System.out.println("Jdbc Url" + config.getJDBCUrl());
		System.out.println("Jdbc User" + config.getJDBCUser());
		System.out.println("Jdbc Password" + config.getJDBCPassword());
	}

	public void createDataBase(String databaseName) {
		Connection connObj = null;
		Statement stmtObj = null;

		try {
			Class.forName(config.getJDBCDriver());
			connObj = DriverManager.getConnection(config.getJDBCUrl(), config.getJDBCUser(), config.getJDBCPassword());
			stmtObj = connObj.createStatement();

			LOGGER.info("\n=====CREATE " + databaseName + " DATABASE======");
			stmtObj.executeUpdate(DBConstants.createDataBase(databaseName));

		} catch (ClassNotFoundException | SQLException e) {
			String msgError = e.getMessage();
			LOGGER.error(msgError, e);
			throw new EhrmException(msgError, e);

		}

	}

}
