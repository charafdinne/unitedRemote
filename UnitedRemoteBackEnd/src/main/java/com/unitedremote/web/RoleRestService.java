package com.unitedremote.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitedremote.entities.Role;
import com.unitedremote.entities.User;
import com.unitedremote.repositories.RoleRepository;
import com.unitedremote.repositories.UserRepository;

@RestController
public class RoleRestService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/addRole")
	public Role saveUser(Role r) {
		return this.roleRepository.save(r);
	}
	
	@GetMapping(value="/getRoles")
	public List<Role> findAll(){
		return this.roleRepository.findAll();
	}		
	
	@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String email, String role) {
		Optional<User> u = this.userRepository.findById(email);
		Optional<Role> r = this.roleRepository.findById(role);
		User user = u.get();
		user.getRoles().add(r.get());
		return this.userRepository.save(user);
	}
}
