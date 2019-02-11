/**
 * 
 */
package com.csf.mama.exception;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author TuanDQ
 *
 */
@ControllerAdvice
public class GolbalExceptionHandler {
	public static final Logger LOGGER = LoggerFactory.getLogger(GolbalExceptionHandler.class);
	@Autowired
	Environment env; // application.properties

	@Autowired
	HttpSession session;

	@SuppressWarnings("unused")
	private static final String DEFAULT_ERROR_VIEW = "error";
	@SuppressWarnings("unused")
	private ErrorCommon errorCommon;

	// Convert a predefined exception to an HTTP Status code
	@ResponseStatus(value = HttpStatus.CONFLICT) // 409
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void conflict() {
		// Nothing to do
	}

	/***
	 * @param request HttpServletRequest
	 * @param ex Exception
	 * @return error page
	 * @throws ServletException
	 * @throws IOException
	 * @throws Exception
	 */
	/*
	 * TODO : Custome exception for Class.
	 * 
	@ExceptionHandler(OrderNotFoundException.class)
	public String handleOrderNotFoundException(ServletRequest request,
			HttpServletResponse response, Exception ex) {
		errorCommon = new ErrorCommon(env);
		//write log
		errorCommon.writeLog(request,ex);
		//get error message
		ErrorMessage errMsg = errorCommon.getErrorInfo("00001");
		request.setAttribute("errMsg", errMsg);
		// get managerSession
		MasDirector masDirector = (MasDirector) session.getAttribute("managerSession");
		if(masDirector != null) {
			request.setAttribute("manager", masDirector);
		}
		// set status response
		response.setStatus(500);
		// return error page
		return DEFAULT_ERROR_VIEW;
	}
	*/

}
