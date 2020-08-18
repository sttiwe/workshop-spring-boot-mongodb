package com.sttiwe.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sttiwe.workshopmongo.domain.User;
import com.sttiwe.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User ellen = new User(null, "Ellen Maciel Alves", "ellen@gmail.com");
		User sttiwe = new User(null, "Sttiwe Sousa", "sttiwew@gmail.com");
		User pandora = new User(null, "Pandora Maciel Sousa", "pands@gmail.com");

		userRepository.saveAll(Arrays.asList(ellen, sttiwe, pandora));
	}

}
