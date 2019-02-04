package com.unitedremote.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(path="/addshop", consumes = {"application/json"})
	public void addShop(Shop shop) {
		this.shopRepository.save(shop);
	}
	
	@DeleteMapping(path="/deleteshop/{id}")
	public void deleteShop(@PathVariable("id") Long id) {
		this.shopRepository.deleteById(id);
	}
	
	@GetMapping(path="/getLikedShops/{id}")
	public Set<Shop> getLikedShops(@PathVariable("id")Long id) {
		Set<Shop> shops = this.userRepository.findById(id).get().getLikedShops();
		return shops;
	}
}