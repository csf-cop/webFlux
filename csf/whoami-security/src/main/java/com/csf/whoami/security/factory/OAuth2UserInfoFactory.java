/**
 * 
 */
package com.csf.whoami.security.factory;

/**
 * @author mba0051
 *
 */
//import com.example.springsocial.exception.OAuth2AuthenticationProcessingException;
//import com.example.springsocial.model.AuthProvider;

import java.util.Map;

import com.csf.whoami.security.entity.AuthProvider;
import com.csf.whoami.security.exception.OAuth2AuthenticationProcessingException;
import com.csf.whoami.security.model.FacebookOAuth2UserInfo;
import com.csf.whoami.security.model.GithubOAuth2UserInfo;
import com.csf.whoami.security.model.GoogleOAuth2UserInfo;
import com.csf.whoami.security.model.OAuth2UserInfo;

public class OAuth2UserInfoFactory {

	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
		if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
			return new GoogleOAuth2UserInfo(attributes);
		} else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
			return new FacebookOAuth2UserInfo(attributes);
		} else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
			return new GithubOAuth2UserInfo(attributes);
		} else {
			throw new OAuth2AuthenticationProcessingException(
					"Sorry! Login with " + registrationId + " is not supported yet.");
		}
	}
}