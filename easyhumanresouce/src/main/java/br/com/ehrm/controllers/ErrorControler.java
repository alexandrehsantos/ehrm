package br.com.ehrm.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControler implements ErrorController {

	private final static String ERROR_PATH = "/error";

	@ExceptionHandler(Exception.class)
	@RequestMapping("/error")
	public String genericError(Throwable t) {
		return "errorpages/genericError";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
