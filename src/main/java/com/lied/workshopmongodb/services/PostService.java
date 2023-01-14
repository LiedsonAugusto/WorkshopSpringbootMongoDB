package com.lied.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lied.workshopmongodb.domain.Post;
import com.lied.workshopmongodb.repositories.PostRepository;
import com.lied.workshopmongodb.services.exception.ObjectNotFound;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound("Id não encontrado"));
	}
	
	public List<Post> findByTitle(String title){
		return postRepository.searchTitle(title);
	}
}
