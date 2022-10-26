package com.luv2code.springdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource datasource = new ComboPooledDataSource();

		try {
			datasource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("===jdbc.url= " + env.getProperty("jdbc.url"));
		logger.info("===jdbc.user=" + env.getProperty("jdbc.user"));

		datasource.setJdbcUrl(env.getProperty("jdbc.url"));
		datasource.setUser(env.getProperty("jdbc.user"));
		datasource.setPassword(env.getProperty("jdbc.password"));

		datasource.setInitialPoolSize(getInt("connection.pool.initialPoolSize"));
		datasource.setMinPoolSize(getInt("connection.pool.minPoolSize"));
		datasource.setMaxPoolSize(getInt("connection.pool.maxPoolSize"));
		datasource.setMaxIdleTime(getInt("connection.pool.maxIdleTime"));

		return datasource;
	}

	private int getInt(String name) {
		return Integer.parseInt(env.getProperty(name));
	}

	private Properties HibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

		return props;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(HibernateProperties());
		return sessionFactory;

	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}
}
