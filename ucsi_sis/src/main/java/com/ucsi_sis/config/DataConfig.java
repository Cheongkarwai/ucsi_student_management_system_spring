package com.ucsi_sis.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataConfig {
	
	@Value("${spring.datasource.url}")
	private String dataSourceUrl;
	
	@Value("${spring.datasource.password}")
	private String dataSourcePassword;
	
	@Value("${spring.datasource.driver-class-name}")
	private String dataSourceDriverName;
	
	@Value("${spring.datasource.username}")
	private String dataSourceUsername;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateAuto;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.dataSourceDriverName);
		dataSource.setUrl(this.dataSourceUrl);
		dataSource.setUsername(this.dataSourceUsername);
		dataSource.setPassword(this.dataSourcePassword);
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", this.hibernateDialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		//This method will create new tables if not exist.
		properties.put("hibernate.hbm2ddl.auto", this.hibernateAuto);
		properties.put("org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction","true");
		return properties;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.ucsi_sis.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(sessionFactory().getObject());
		return jpaTransactionManager;
	}

}
