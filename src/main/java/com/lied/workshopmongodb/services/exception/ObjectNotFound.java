package com.lied.workshopmongodb.services.exception;

public class ObjectNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFound(String msg) {
		super(msg);
	}
	

}
