package com.narad.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * This is a main class to start the application
 * @author Devendra
 *
 */
@ComponentScan("com.narad.*")
@EntityScan(basePackages = {"com.narad.db.domain","com.narad.application.main"})
@SpringBootApplication
public class Application {

	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
