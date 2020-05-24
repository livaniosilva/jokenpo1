package com.livanio.jokenpo1.controller;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livanio.jokenpo1.model.User;
import com.livanio.jokenpo1.repository.UserRepository;
import com.livanio.jokenpo1.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	private Long id;
	
	private UserRepository repository;
	
	/*Replace @Autowired witch is no longer used as a good practice of spring */
	UserController(UserRepository userRepository) {
	       this.repository = userRepository;
	   }
	
	@PostMapping("create")
	public User createUser(@RequestBody User user) {
		return repository.save(user);
		
	}
	
	@GetMapping("listall")
	public List<User>listUsers(){
		return (List<User>) repository.findAll();
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<User> buscar(@PathVariable Long id) {
		Optional<User> user = repository.findById(id);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value="update/{id}")
	public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user) {
	   return repository.findById(id)
	           .map(record -> {
	               record.setName(user.getName());
	               User updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"delete/{id}"})
	public ResponseEntity<Object> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
