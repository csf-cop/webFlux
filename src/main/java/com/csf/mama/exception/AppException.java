/**
 * 
 */
package com.csf.mama.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.csf.mama.util.ConstantsError;

/**
 * @author TuanDQ
 *
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = -8999932578270387947L;

	private Messages message;

	private Object[] params;

	public AppException() {
		super();
	}

	public AppException(AppException appEx, Throwable ex) {
		super(ex);
		this.message = appEx.message;
		this.params = appEx.params;
	}

	public AppException(Messages message) {
		super();
		this.message = message;
	}

	public AppException(Messages message, Object[] params) {
		super();
		this.message = message;
		this.params = params;
	}

	/**
	 * AppException
	 * 
	 * @param message
	 */
	public AppException(Messages message, String developerMessage) {
		super();
		this.message = message;
	}

	/**
	 * AppException
	 * 
	 * @param message
	 * @param params
	 */
	public AppException(Messages message, Object[] params, String developerMessage) {
		super();
		this.message = message;
		this.params = params;
	}

	/**
	 * AppException
	 * 
	 * @param cause
	 */
	public AppException(Throwable cause) {
		super(cause);
	}

	/**
	 * AppException
	 * 
	 * @param message
	 * @param cause
	 */
	public AppException(Messages message, Throwable cause) {
		super(cause);
		this.message = message;
	}

	/**
	 * AppException
	 * 
	 * @param message
	 * @param params
	 * @param cause
	 */
	public AppException(Messages message, Object[] params, Throwable cause) {
		super(cause);
		this.message = message;
		this.params = params;
	}

	@Override
	public String getMessage() {
		if (message != null) {
			String messageFormat = MessageProperties.open().getProperty(message.getMessageId());
			if (!StringUtils.isEmpty(messageFormat)) {
				if (params == null || params.length == 0) {
					return messageFormat;
				}
				return MessageFormat.format(messageFormat, params);
			}
			return message.getMessageId();
		}
		return null;
	}

	/**
	 * getApplicationCode
	 * 
	 * @return
	 */
	public int getApplicationCode() {
		if (message != null) {
			return message.getApplicationCode();
		}
		return ConstantsError.RETURN_CODE_ERROR;
	}

	/**
	 * getHttpStatus
	 * 
	 * @return
	 */
	public HttpStatus getHttpStatus() {
		if (message != null) {
			return message.getHttpStatus();
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	/**
	 * getMessageId
	 * 
	 * @return
	 */
	public String getMessageId() {
		if (message != null) {
			return message.getMessageId();
		}
		return null;
	}

	/**
	 * setParams
	 * 
	 * @param params
	 *            params
	 */
	protected void setParams(Object[] params) {
		this.params = params;
	}
}
