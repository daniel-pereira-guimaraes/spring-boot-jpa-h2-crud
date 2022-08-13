package com.example.spring.boot.jpa.h2.crud.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
	
	private Object data;
	private List<String> messages = new ArrayList<String>();
	
	public ResponseDTO() {
		super();
	}

	public ResponseDTO(Object data) {
		super();
		this.data = data;
	}

	public ResponseDTO(Object data, String message) {
		super();
		this.data = data;
		this.messages.add(message);
	}

	public ResponseDTO(Object data, List<String> messages) {
		super();
		this.data = data;
		this.messages.addAll(messages);
	}

	public ResponseDTO(String message) {
		super();
		this.messages.add(message);
	}

	public ResponseDTO(List<String> messages) {
		super();
		this.messages.addAll(messages);
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public List<String> getMessages() {
		return this.messages;
	}
	
	public void setMessage(List<String> messages) {
		this.messages = messages;
	}
		
}
