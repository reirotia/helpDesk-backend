package com.reinaldo.helpDesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.reinaldo.helpDesk.services.DBServices;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBServices dbServices;

	// para pegar o valor da propriedade do application properties
	//@Value("${}spring.profiles.active")
	//private String value;

	@Bean
	public void instaciaDB() {

		// pegando o valor da propriedade do aplicattion properties
		// if (value.equals("create")) {

		this.dbServices.instanciaDB();
	}

}
