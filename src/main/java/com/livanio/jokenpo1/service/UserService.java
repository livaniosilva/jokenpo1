package com.livanio.jokenpo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.livanio.jokenpo1.model.User;
import com.livanio.jokenpo1.repository.UserRepository;

@Component
public class UserService {
	private UserRepository repository;
	
	UserService(UserRepository userRepository){
		this.repository = userRepository;
	}
	
	public List<User> listall(){
		return (List<User>) repository.findAll();
		
	}
	
	public ResponseEntity <User> findById(Long id) {
	Optional<User> user = repository.findById(id);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	

}
