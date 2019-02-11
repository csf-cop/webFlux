/**
 * 
 */
package com.csf.mama.exception;

import org.springframework.http.HttpStatus;

import com.csf.mama.util.ConstantsError;

/**
 * @author TuanDQ
 *
 */
public enum Messages {

	EC9001(ConstantsError.RETURN_CODE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR), EC9002(
			ConstantsError.RETURN_CODE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR), EC9003(
					ConstantsError.RETURN_CODE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

	private String messageId;

	private int applicationCode;

	private HttpStatus httpStatus;

	/**
	 * construct Messages
	 * 
	 * @param applicationCode
	 * @param httpStatus
	 */
	private Messages(int applicationCode, HttpStatus httpStatus) {
		this.messageId = this.name();
		this.applicationCode = applicationCode;
		this.httpStatus = httpStatus;
	}

	/**
	 * messageId
	 * 
	 * @return messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * applicationCode
	 * 
	 * @return applicationCode
	 */
	public int getApplicationCode() {
		return applicationCode;
	}

	/**
	 * getHttpStatus
	 * 
	 * @return httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * setHttpStatus
	 * 
	 * @return httpStatus
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
