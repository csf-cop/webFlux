/**
 * 
 */
package com.csf.mama.exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TuanDQ
 *
 */
public class MessageProperties {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageProperties.class);
	
	public static final String PROPERTIES_FILE = "exception-dev_beach.properties";

	public static Properties properties = new Properties();
	
	public static MessageProperties messageProperties;
	
	public static Properties open(){
		if(messageProperties==null)
			messageProperties = new MessageProperties();
		return properties;
	}
	
	public MessageProperties(){
		InputStream inputStream = MessageProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
		if (inputStream != null) {
			try {
				
				properties.load(inputStream);
				inputStream.close();
			} catch (IOException e) {
				LOGGER.error("Error", e);
			}
		}
	}

	public static String getMessage(String messageId) {
		return properties.getProperty(messageId);
	}
}

