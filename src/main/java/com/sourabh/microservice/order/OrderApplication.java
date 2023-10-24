package com.sourabh.microservice.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class OrderApplication {
	@Value("${spring.datasource.url}")
    	private String jdbcUrl;

	 @Value("${spring.datasource.username}")
    	private String jdbcUsername;

    	@Value("${spring.datasource.password}")
    	private String jdbcPassword;


	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@PostConstruct
    	public void logJdbcUrlAndCredentials() {
        	System.out.println("JDBC URL: " + jdbcUrl);
        	System.out.println("Username: " + jdbcUsername);
       	 	System.out.println("Password: " + jdbcPassword);
    	}

}
