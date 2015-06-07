package org.minyo.payroll;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"org.minyo.payroll"org.minyo.payroll.repos"})
public class WebService {
	
	public static void main(String[] args) {
		
		SpringApplication.run(WebService.class, args);
	}

}
