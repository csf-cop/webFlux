/**
 * 
 */
package com.whoami.common.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author mba0051
 *
 */
public class StringUtils {

	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
	@SuppressWarnings("unused")
	private static String generateUUIDWithSHA256() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest salt = MessageDigest.getInstance("SHA-256");
		salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
//		String digest = bytesToHex(salt.digest());
		return null;
	}
}
