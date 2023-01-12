package com.lied.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lied.workshopmongodb.domain.User;
import com.lied.workshopmongodb.dto.UserDTO;
import com.lied.workshopmongodb.repositories.UserRepository;
import com.lied.workshopmongodb.services.exception.ObjectNotFound;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFound("Id não encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(String id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFound("Id não encontrado");
		}
	}
	
	public User updateUser(String id, User obj) {
		Optional<User> entity = userRepository.findById(id);
		User newObj = new User(entity.get().getId(), entity.get().getName(), entity.get().getEmail());
		updateData(newObj, obj);
		return userRepository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
