package com.unitedremote.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User implements Serializable {
//
//	@Id
//	@GeneratedValue
//	private Long id;
	@Id
	private String email;
	private String password;
	private Boolean activated;
	@ManyToMany
	@JoinTable(name = "USERS_ROLES", joinColumns= { @JoinColumn(name = "user_email") }, inverseJoinColumns = { 
			@JoinColumn(name="role_nom")}) 
	private Set<Role> roles;
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "shop_user", joinColumns = { @JoinColumn(name = "user_email") }, inverseJoinColumns = {
			@JoinColumn(name = "shop_id") })
	private Set<Shop> likedShops = new HashSet<Shop>();

	public User() {

	}

	public User(String email, String password, Boolean activated) {
		super();
		this.email = email;
		this.password = password;
		this.activated = activated;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
}
