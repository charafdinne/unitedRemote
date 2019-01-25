package com.unitedremote.web;

import java.util.List;
import java.util.Optional;

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

@ResponseBody
@RestController
@CrossOrigin("*")
public class ShopRestService {

	@Autowired
	private ShopRepository shopRepository;

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
	
}