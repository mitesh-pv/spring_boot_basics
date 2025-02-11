package io.spring.jpaexample.SpringJpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.spring.jpaexample.SpringJpa.entities.User;
import io.spring.jpaexample.SpringJpa.service.UserService;

@Component
public class UserServiceCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	private static final Logger log=LoggerFactory.getLogger(UserServiceCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		
		User jack=new User("Jack", "Admin");
		
		userService.insert(jack);
		
		log.info("new user is created : "+jack);
		
	}
	
	

}
