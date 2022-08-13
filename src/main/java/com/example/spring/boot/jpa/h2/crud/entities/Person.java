package com.example.spring.boot.jpa.h2.crud.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // Necessária quando atributo e coluna têm nomes diferentes.
	Long id;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "{msg.name.required}")
	String name;
	
	@Column(length = 15)
	@Size(max = 15, message = "{msg.telephone.max}")
	String telephone;
	
	LocalDate birthDate;
	
	@Column(precision = 18, scale = 2)
	@NotNull(message = "{msg.salary.required}")
	@Min(value = 0, message = "{msg.salary.not.negative}")
	BigDecimal salary;
	
}
