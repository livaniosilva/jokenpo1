package com.livanio.jokenpo1.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.livanio.jokenpo1.enumerated.PlayType;
import com.livanio.jokenpo1.model.User;
import com.livanio.jokenpo1.repository.UserRepository;

@Component
public class GameService {
private UserRepository repository;
private PlayType playType;
	
	GameService(UserRepository userRepository){
		this.repository = userRepository;
	}
	
	public User WhosTheWinner(User userA, User userB) {
		
		switch (userA.getPlay()) {
		case SPOCK: 
			switch (userB.getPlay()) {
				case TESOURA: 
						System.out.println("Vencedor é: " + userA);
						break;
				case PEDRA: 
						System.out.println("Vencedor é: " + userA);
						break;
				case PAPEL:
						System.out.println("vencedor eh :" + userB);
						break;
				case LAGARTO: 	
					System.out.println("Vencedor é: " + userB);
					break;
		
				default:
					break;
		}
			
		case TESOURA: 
			switch (userB.getPlay()) {
				case PAPEL: 
						System.out.println("Vencedor é: " + userA);
						break;
				case LAGARTO: 
						System.out.println("Vencedor é: " + userA);
						break;
				case SPOCK:
						System.out.println("vencedor eh :" + userB);
						break;
				case PEDRA: 	
					System.out.println("Vencedor é: " + userB);
					break;
		
				default:
					break;
		}
			
		case PAPEL: 
			switch (userB.getPlay()) {
				case SPOCK: 
						System.out.println("Vencedor é: " + userA);
						break;
				case PEDRA: 
						System.out.println("Vencedor é: " + userA);
						break;
				case TESOURA:
						System.out.println("vencedor eh :" + userB);
						break;
				case LAGARTO: 	
					System.out.println("Vencedor é: " + userB);
					break;
		
				default:
					break;
		}
		case PEDRA: 
			switch (userB.getPlay()) {
				case LAGARTO: 
						System.out.println("Vencedor é: " + userA);
						break;
				case TESOURA: 
						System.out.println("Vencedor é: " + userA);
						break;
				case SPOCK:
						System.out.println("vencedor eh :" + userB);
						break;
				case PAPEL: 	
					System.out.println("Vencedor é: " + userB);
					break;
		
				default:
					break;
		}
			
		case LAGARTO: 
			switch (userB.getPlay()) {
				case SPOCK: 
						System.out.println("Vencedor é: " + userA);
						break;
				case PAPEL: 
						System.out.println("Vencedor é: " + userA);
						break;
				case TESOURA:
						System.out.println("vencedor eh :" + userB);
						break;
				case PEDRA: 	
					System.out.println("Vencedor é: " + userB);
					break;
		
				default:
					break;
		}
			
		default:
			break;
		
	   }
		return userA;
		
	}
	
	
	public Optional<Object> playGame(List<User> users) {
		
	Optional<Object> winner =  Arrays.stream(users.toArray()).reduce((u1,u2)-> u1);
	
	WhosTheWinner(users.get(0), users.get(1));
	
		return winner;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
