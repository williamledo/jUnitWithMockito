package com.williamledo.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamledo.api.domain.User;
import com.williamledo.api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findById(Integer id) {

		Optional<User> obj = repository.findById(id);
		return obj.orElse(null);
		
	}
	
}
