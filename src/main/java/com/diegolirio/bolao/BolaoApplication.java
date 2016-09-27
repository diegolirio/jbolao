package com.diegolirio.bolao;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class BolaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolaoApplication.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
		String host = System.getenv( "OPENSHIFT_MYSQL_DB_HOST" );
		String port = System.getenv( "OPENSHIFT_MYSQL_DB_PORT" );
		if(StringUtils.isEmpty(host) == true) { 
			return dataSourceDEV();
		} 
		return dataSourceCloud(host, port, "adminjMClW8b", "dcJsIppvPT-E");
	}	
	
	private DataSource dataSourceCloud(String host, String port, String user, String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/bolao");
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	public DataSource dataSourceDEV() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/bolao");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
}
