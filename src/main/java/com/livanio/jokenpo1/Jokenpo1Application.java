package com.livanio.jokenpo1;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.livanio.jokenpo1.model.User;
import com.livanio.jokenpo1.repository.UserRepository;

@SpringBootApplication
public class Jokenpo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Jokenpo1Application.class, args);
	}
	

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            userRepository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        User u = new User();
                        u.setName("Contact " + i);

                        return u;
                    })
                    .map(v -> userRepository.save(v))
                    .forEach(System.out::println);
        };
    }


}
