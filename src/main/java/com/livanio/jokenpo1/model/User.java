package com.livanio.jokenpo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.livanio.jokenpo1.enumerated.PlayType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Game games;
	
	@Column(nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Game getGames() {
		return games;
	}

	public void setGames(Game games) {
		this.games = games;
	}


	public PlayType getPlay() {
		return play;
	}

	public void setPlay(PlayType play) {
		this.play = play;
	}


	@Enumerated
	@Column(nullable = false)
	private PlayType play;

}
