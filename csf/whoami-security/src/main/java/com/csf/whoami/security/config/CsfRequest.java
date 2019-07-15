/**
 * 
 */
package com.csf.whoami.security.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tuan
 *
 */
//@Component
public class CsfRequest implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterchain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// Get username & password : basic
		final String authorization = request.getHeader("Authorization");
		if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
//			String message = checkBasicAuthentication(request, authorization);
//			if (message != null) {
//				// fail username & password.
//				// can not connect to login account.
//				// Invalis username & password. - Empty || null
//			} else {
//				// Case have no body.
//				Map<String, String[]> headers = request.getParameterMap();
//				for (Map.Entry<String, String[]> entry : headers.entrySet()) {
//					System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
//				}
//			}
		} else if (authorization == null) {
			// Setting default authenticate (basic token).
		}

		filterchain.doFilter(request, response);
	}

	private String checkBasicAuthentication(HttpServletRequest request, String authorization) {
		// Authorization: Basic base64credentials
		String base64Credentials = authorization.substring("Basic".length()).trim();
		byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
		String credentials = new String(credDecoded, StandardCharsets.UTF_8);
		// credentials = username:password
		String username = credentials.split(":", 2)[0];
		String password = credentials.split(":", 2)[1];

		return null;
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO : Full
		/*
		 * Authorize value: Basic d2hvYW1pLWNsaWVudDp3aG9hbWktc2VjcmV0 Parameter map:
		 * Key : username Value : [Ljava.lang.String;@271c43ec Key : password Value :
		 * [Ljava.lang.String;@773516e8 Key : grant_type Value :
		 * [Ljava.lang.String;@5f7e182
		 */

		// TODO : have no body
		/*
		 * Authorize value: Basic d2hvYW1pLWNsaWVudDp3aG9hbWktc2VjcmV0 Parameter map:
		 */

		// TODO : no Authenticate : have no value.
	}
}