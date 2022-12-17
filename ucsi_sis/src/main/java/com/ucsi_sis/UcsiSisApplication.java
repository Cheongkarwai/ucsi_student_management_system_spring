package com.ucsi_sis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
public class UcsiSisApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcsiSisApplication.class, args);
	}

}
