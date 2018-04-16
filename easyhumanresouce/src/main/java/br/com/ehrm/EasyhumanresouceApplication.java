package br.com.ehrm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyhumanresouceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EasyhumanresouceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EasyhumanresouceApplication.class, args);
		LOGGER.debug("--Application Started--");
	}
}
