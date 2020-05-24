package com.livanio.jokenpo1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livanio.jokenpo1.model.Game;
import com.livanio.jokenpo1.repository.GameRepository;

@RestController
@RequestMapping("games/")
public class GameController {
	private GameRepository repository;
	
	GameController(GameRepository gameRepository) {
	       this.repository = gameRepository;
	   }
	
	@GetMapping("allgame")
	public List<Game>findAll() {
		return (List<Game>) repository.findAll();
	}

	@PostMapping("create")
	public Game createGame(@RequestBody Game game) {
		return repository.save(game);
	}
	
	@DeleteMapping(path ={"delete/{id}"})
	public ResponseEntity<Object> delete(@PathVariable long id) {
		   return repository.findById(id)
		           .map(record -> {
		               repository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		}
		
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Game> buscar(@PathVariable Long id) {
		Optional<Game> game = repository.findById(id);
		
		if (game.isPresent()) {
			return ResponseEntity.ok(game.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	

}
