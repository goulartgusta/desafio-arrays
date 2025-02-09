package br.com.almaviva.desafio.array.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

	public void info(String message) {
		logger.info(message);
	}
	
	public void error(String error) {
		logger.info(error);
	}
}