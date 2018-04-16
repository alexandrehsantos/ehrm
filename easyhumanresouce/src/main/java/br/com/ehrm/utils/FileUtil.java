package br.com.ehrm.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ehrm.EasyhumanresouceApplication;
import br.com.ehrm.exception.EhrmException;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUtil.
 */
public class FileUtil {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EasyhumanresouceApplication.class);

	/**
	 * Load properties.
	 *
	 * @param fileName
	 *            the file name
	 * @return the properties
	 */
	public Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(fileName));
			return properties;
		} catch (IOException e) {
			String errorMsg = "Erro ao carregar arquivo:" + fileName;
			LOGGER.error(errorMsg, e);
			throw new EhrmException(errorMsg, e);
		}
	}

	
	
}
