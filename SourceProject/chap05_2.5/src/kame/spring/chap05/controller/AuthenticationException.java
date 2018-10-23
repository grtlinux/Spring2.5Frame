package kame.spring.chap05.controller;

public class AuthenticationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationException(String message) {
		super(message);
	}

}
