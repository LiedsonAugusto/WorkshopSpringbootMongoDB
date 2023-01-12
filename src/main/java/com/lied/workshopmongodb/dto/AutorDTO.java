package com.lied.workshopmongodb.dto;

import com.lied.workshopmongodb.domain.User;

public class AutorDTO {
	
	private String id;
	private String name;
	
	public AutorDTO() {
	}
	
	public AutorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
