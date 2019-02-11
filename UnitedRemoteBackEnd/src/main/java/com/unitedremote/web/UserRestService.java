package com.unitedremote.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitedremote.entities.User;
import com.unitedremote.repositories.UserRepository;

//@Secured(value={"ADMIN"})
@RestController
public class UserRestService {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/addUser")
	public User saveUser(User u) {
		return this.userRepository.save(u);
	}
	
	@GetMapping(value="/getUsers")
	public List<User> finAll(){
		return this.userRepository.findAll();
	}		
}
