package br.com.ehrm.utils;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConstants.
 */
public class DBConstants {

	/** The Constant CREATE_DATABASE. */
	private static final String CREATE_DATABASE = "CREATE DATABASE ";

	private static final String CREATE_TABLE = "CREATE TABLE ";

	/** The Constant END_OF_LINE. */
	private static final String END_OF_LINE = ";";

	/**
	 * Creates the data base.
	 *
	 * @param dbName
	 *            the db name
	 * @return the string
	 */
	public static String createDataBase(String dbName) {

		return CREATE_DATABASE + dbName + END_OF_LINE;
	}

	public static String createTable(String tableStructure) {

		return CREATE_TABLE + tableStructure + END_OF_LINE;
	}

}
