/**
 * 
 */
package com.csf.whoami.config;

import java.io.Serializable;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

/**
 * @author TuanDQ
 *
 */
public class RealNamingStrategyImpl extends SpringPhysicalNamingStrategy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final PhysicalNamingStrategyStandardImpl INSTANCE = new PhysicalNamingStrategyStandardImpl();

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return new Identifier(name.getText().toUpperCase(), true);
	}

}
