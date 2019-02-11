/**
 * 
 */
package com.csf.mama.exception;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author TuanDQ
 *
 */
@Configuration
//@PropertySource(value = "classpath:/exception-${spring.profiles.active}.properties", encoding = "UTF-8")
public class ErrorCommon {

	Environment env; // application.propertiesを保持するPropertyオブジェクト

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

	public ErrorCommon(Environment env) {
		this.env = env;
	}

	/***
	 * 概要 ： get Error Info 作成日 ： 2016/12/03 作成者 ： FPT)NhiNHY1
	 * 
	 * @param id
	 *            message
	 * @return
	 */
	public ErrorMessage getErrorInfo(String id) {
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setErrSubject(env.getProperty("ES" + id));
		errMsg.setErrContent(env.getProperty("EC" + id));
		return errMsg;
	}

	/***
	 * 概要 ： write Log when exception 作成日 ： 2016/12/03 作成者 ： FPT)NhiNHY1
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param ex
	 *            Exception
	 */
	public void writeLog(ServletRequest request, Exception ex) {
		logger.info("*****************Exceptionが発生しました****************");
		logger.info("Occured:: URL = " + ((HttpServletRequest) request).getRequestURL());
		logger.info("Occured:: MSG = " + ex.getMessage());
		logger.info("Occured:: MSG = " + ex.toString());
	}
}
