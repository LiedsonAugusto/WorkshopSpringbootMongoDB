package com.lied.workshopmongodb.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String text;
	@JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	private AutorDTO author;

	public CommentDTO() {
	}

	public CommentDTO(String text, Instant date, AutorDTO autor) {
		this.text = text;
		this.date = date;
		this.author = autor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public AutorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AutorDTO author) {
		this.author = author;
	}
}
