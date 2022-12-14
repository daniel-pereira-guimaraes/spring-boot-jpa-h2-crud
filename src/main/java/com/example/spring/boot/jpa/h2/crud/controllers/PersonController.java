package com.example.spring.boot.jpa.h2.crud.controllers;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.jpa.h2.crud.dto.ResponseDTO;
import com.example.spring.boot.jpa.h2.crud.entities.Person;
import com.example.spring.boot.jpa.h2.crud.repositories.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getAll() {
		try {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(personRepository.selectAll()), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/{param}")
	public ResponseEntity<ResponseDTO> getById(@PathVariable String param) {
		try {
			Object result = param.matches("\\d*") ?
				personRepository.selectById(Long.parseLong(param)) :
				personRepository.selectLikeName(param);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(result), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{min}/{max}")
	public ResponseEntity<ResponseDTO> getSalaryBetween(@PathVariable BigDecimal min, @PathVariable BigDecimal max) {
		try {
			return new ResponseEntity<ResponseDTO>(
				new ResponseDTO(personRepository.selectSalaryBetween(min, max)), 
				HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO> post(@Valid @RequestBody Person person) {
		try {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(personRepository.insert(person)), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@PutMapping
	public ResponseEntity<ResponseDTO> put(@Valid @RequestBody Person person) {
		try {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(personRepository.update(person)), HttpStatus.OK); 
		} catch(Exception e) {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
		try {
			personRepository.delete(id);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
