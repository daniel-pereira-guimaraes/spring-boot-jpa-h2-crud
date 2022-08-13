package com.example.spring.boot.jpa.h2.crud.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
	
	private Object data;
	private List<String> messages;
	
	public ResponseDTO(Object data) {
		super();
		this.data = data;
	}

	public ResponseDTO(Object data, String message) {
		super();
		this.data = data;
		this.setMessages(message);
	}

	public ResponseDTO(String message) {
		super();
		this.setMessages(message);
	}

	public ResponseDTO(List<String> messages) {
		super();
		this.messages = messages;
	}
		
	public void setMessages(String message) {
		this.messages = new ArrayList<String>(Arrays.asList(message));
	}
}
