package com.unitedremote.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitedremote.entities.Shop;
import com.unitedremote.repositories.ShopRepository;
import com.unitedremote.repositories.UserRepository;

@ResponseBody
@RestController
@CrossOrigin("*")
public class ShopRestService {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping(path = "/shops", produces = { "application/json" })
	public List<Shop> getShops() {
		return this.shopRepository.findAll();
	}

	@GetMapping(path = "/shop/{id}", produces = { "application/json" })
	public Optional<Shop> getShop(@PathVariable("id") Long id) {
		return this.shopRepository.findById(id);
	}

	@Secured(value = { "ROLE_ADMIN" })
	@PostMapping(path = "/addshop", consumes = { "application/json" })
	public void addShop(Shop shop) {
		this.shopRepository.save(shop);
	}

	@DeleteMapping(path = "/deleteshop/{id}")
	public void deleteShop(@PathVariable("id") Long id) {
		this.shopRepository.deleteById(id);
	}

	@GetMapping(path = "/getLikedShops/{email}")
	public Set<Shop> getLikedShops(@PathVariable("email") String email) {
		Set<Shop> shops = this.userRepository.findById(email).get().getLikedShops();
		return shops;
	}

	@RequestMapping(value = "/getLoggedUser")
	public Map<String, Object> getLoggedUser(HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String userName = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("username", userName);
		params.put("roles", roles);
		return params;
	}
}