package com.lied.workshopmongodb.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lied.workshopmongodb.dto.AutorDTO;
import com.lied.workshopmongodb.dto.CommentDTO;

@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	private String title;
	private String body;
	private AutorDTO author;
	private List<CommentDTO> comments = new ArrayList<>();
	
	public Post() {
	}

	public Post(String id, Instant date, String title, String body, AutorDTO author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AutorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AutorDTO author) {
		this.author = author;
	}
	
	public List<CommentDTO> getComments() {
		return comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
}
