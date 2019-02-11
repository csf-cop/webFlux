/**
 * 
 */
package com.csf.mama.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javassist.NotFoundException;

/**
 * @author TuanDQ
 *
 */
@ControllerAdvice
public class ExceptionHandlingController {

	@Autowired
	Environment env; // application.properties

	@Autowired
	HttpSession session;

	private static final String DEFAULT_ERROR_VIEW = "error";
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
	 */
	@ExceptionHandler(NotFoundException.class)
	public String handleNotFoundException(HttpServletRequest request,
			HttpServletResponse response, Exception ex) {
		
		errorCommon = new ErrorCommon(env);
		errorCommon.writeLog(request,ex);
		
		// TODO : Add custom Message base requirement.
//		ErrorMessage errMsg = errorCommon.getErrorInfo("00005");
//		request.setAttribute("errMsg", errMsg);
		
		return DEFAULT_ERROR_VIEW;
	}
}
