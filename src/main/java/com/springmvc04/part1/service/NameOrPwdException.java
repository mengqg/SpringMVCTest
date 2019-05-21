package com.springmvc04.part1.service;

public class NameOrPwdException extends Exception {
	public NameOrPwdException() {
		
	}
	public NameOrPwdException(String message) {
		super(message);
	}
	public NameOrPwdException(Throwable cause) {
		super(cause);
	}
	public NameOrPwdException(String message, Throwable cause) {
		super(message, cause);
	}
}
