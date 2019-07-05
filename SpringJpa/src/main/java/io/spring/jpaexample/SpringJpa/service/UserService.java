package io.spring.jpaexample.SpringJpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.spring.jpaexample.SpringJpa.entities.User;

@Repository
@Transactional
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
