package com.unitedremote.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class User {

	@Id @GeneratedValue
	private Long id;
	private String email;
	private String password;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="shop_user",
		joinColumns= { @JoinColumn(name="user_id") },
		inverseJoinColumns = { @JoinColumn(name="shop_id")})
	private Set<Shop> likedShops = new HashSet<Shop>();

	public User() {
		
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Shop> getLikedShops() {
		return likedShops;
	}

	public void setLikedShops(Set<Shop> likedShops) {
		this.likedShops = likedShops;
	}
	
}
