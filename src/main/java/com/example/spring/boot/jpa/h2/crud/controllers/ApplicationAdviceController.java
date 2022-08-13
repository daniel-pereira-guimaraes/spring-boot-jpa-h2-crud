package com.example.spring.boot.jpa.h2.crud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.spring.boot.jpa.h2.crud.dto.ResponseDTO;

@RestControllerAdvice
public class ApplicationAdviceController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseDTO MethodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e) {
		List<String> messages = new ArrayList<String>();
		e.getAllErrors().forEach(error -> {
			messages.add(error.getDefaultMessage());
		});
		return new ResponseDTO(messages);
	}
	

}
