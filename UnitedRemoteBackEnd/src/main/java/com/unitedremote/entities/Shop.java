package com.unitedremote.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="shop")
public class Shop {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nom;
	
	private String adresse;
	
	private String photo;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, mappedBy= "likedShops")
	private Set<User> usersLiked = new HashSet<User>();
	
	public Shop() {
		
	}
	
	public Shop(String nom, String adresse, String photo,Integer distance) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<User> getUsersLiked() {
		return usersLiked;
	}

	public void setUsersLiked(Set<User> usersLiked) {
		this.usersLiked = usersLiked;
	}			
	
}
