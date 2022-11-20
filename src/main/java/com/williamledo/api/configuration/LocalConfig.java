package com.williamledo.api.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.williamledo.api.domain.User;
import com.williamledo.api.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {

	@Autowired
	private UserRepository repository;
	
	@Bean
	public void startDB() {
		User u1 = new User(null, "William", "will@mail.com", "123");
		User u2 = new User(null, "Luiz", "luiz@mail.com", "123");
		
		repository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
