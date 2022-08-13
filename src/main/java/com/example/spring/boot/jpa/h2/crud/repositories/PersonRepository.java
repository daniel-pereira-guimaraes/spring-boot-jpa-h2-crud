package com.example.spring.boot.jpa.h2.crud.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.jpa.h2.crud.entities.Person;

@Repository
public class PersonRepository {

	@Autowired
	private EntityManager entityManager;

	public Person selectById(Long id) throws Exception {
		Person p = entityManager.find(Person.class, id);
		if (p == null)
			throw new Exception("Pessoa não encontrada: " + id);
		return p;
	}
	
	public List<Person> selectLikeName(String name) throws Exception {
		String jpql = "SELECT p FROM Person p WHERE UPPER(p.name) LIKE UPPER(:name)";
		return entityManager.createQuery(jpql, Person.class)
			.setParameter("name", "%" + name + "%")
			.getResultList();
	}

	/* Exemplo de consulta tipada. */
	public List<Person> selectAll() {
		String jpql = "SELECT new com.example.spring.boot.jpa.h2.crud.entities.Person(p.id, p.name, p.telephone, p.birthDate, p.salary) FROM Person p";
		TypedQuery<Person> query = entityManager.createQuery(jpql, Person.class);
		return query.getResultList();
	}
	
	@Transactional
	public Person insert(Person person) {
		person.setName(person.getName().toUpperCase());
		entityManager.persist(person);
		return person;
	}
	
	@Transactional // Controle implícito da transação.
	public Person update(Person person) {
		person.setName(person.getName().toUpperCase());
		entityManager.merge(person);
		return person;
	}
	
	@Transactional
	public void delete(Long id) throws Exception {
		entityManager.remove(selectById(id));
	}

}
