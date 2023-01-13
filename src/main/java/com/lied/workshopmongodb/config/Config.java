package com.lied.workshopmongodb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lied.workshopmongodb.domain.Post;
import com.lied.workshopmongodb.domain.User;
import com.lied.workshopmongodb.dto.AutorDTO;
import com.lied.workshopmongodb.dto.CommentDTO;
import com.lied.workshopmongodb.repositories.PostRepository;
import com.lied.workshopmongodb.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para SP", new AutorDTO(maria));
		Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz", new AutorDTO(maria));
		
		CommentDTO com1 = new CommentDTO("Boa viagem", Instant.now(), new AutorDTO(alex));
		CommentDTO com2 = new CommentDTO("Tenha um bom dia", Instant.now(), new AutorDTO(alex));
		CommentDTO com3 = new CommentDTO("Aproveite", Instant.now(), new AutorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(com1, com2));
		post2.getComments().addAll(Arrays.asList(com3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
		
	}

}
