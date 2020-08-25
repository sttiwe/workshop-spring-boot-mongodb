package com.sttiwe.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sttiwe.workshopmongo.domain.Post;
import com.sttiwe.workshopmongo.domain.User;
import com.sttiwe.workshopmongo.repository.PostRepository;
import com.sttiwe.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User ellen = new User(null, "Ellen Maciel Alves", "ellen@gmail.com");
		User sttiwe = new User(null, "Sttiwe Sousa", "sttiwew@gmail.com");
		User pandora = new User(null, "Pandora Maciel Sousa", "pands@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", ellen);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei faliz hoje!", ellen);
		
		userRepository.saveAll(Arrays.asList(ellen, sttiwe, pandora));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
