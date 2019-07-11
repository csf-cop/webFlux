/**
 * 
 */
package com.csf.whoami.firebase;

import org.springframework.context.annotation.Configuration;

/**
 * @author TuanDQ
 *
 */
@Configuration
public class FirebaseConfig {

//	@Bean
//	public DatabaseReference firebaseDatabse() {
//		DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
//		return firebase;
//	}
//
//	@Value("${spring.firebase.database.url}")
//	private String databaseUrl;
//
//	@Value("${spring.firebase.config.path}")
//	private String configPath;
//
//	@PostConstruct
//	public void init() {
//
//		/**
//		 * https://firebase.google.com/docs/server/setup
//		 * 
//		 * Create service account , download json
//		 */
//		InputStream inputStream = FirebaseConfig.class.getClassLoader().getResourceAsStream(configPath);
//
//		FirebaseOptions options = new FirebaseOptions.Builder().setServiceAccount(inputStream)
//				.setDatabaseUrl(databaseUrl).build();
//		FirebaseApp.initializeApp(options);
//
//	}
}
