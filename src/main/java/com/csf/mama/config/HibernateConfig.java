/**
 * 
 */
package com.csf.mama.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author TuanDQ
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgreEntityManagerFactory", 
        basePackages = {"com.csf.mama.repository"}, 
        transactionManagerRef = "postgreTransactionManager")
public class HibernateConfig {
	@Bean(name = "postgreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postgreEntityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
      sessionFactoryBean.setDataSource(dataSource());
      sessionFactoryBean.setPackagesToScan("com.csf.mama.entity");
      Properties hibernateProperties = new Properties();
      hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
      hibernateProperties.put("hibernate.show_sql", false);
      hibernateProperties.put("hibernate.format_sql", false);
      hibernateProperties.put("hibernate.generate_statisticsl", false);
      hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
      sessionFactoryBean.setHibernateProperties(hibernateProperties);

      return sessionFactoryBean;
    }

    @Bean(name = "oracleTransactionManager")
    public HibernateTransactionManager transactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(sessionFactory().getObject());
      return transactionManager;
    }
}
