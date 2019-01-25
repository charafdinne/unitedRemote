package com.unitedremote.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="shop")
public class Shop {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nom;
	
	private String adresse;
	
	private String photo;

	private Boolean liked;
	
	public Shop() {
		
	}
	
	public Shop(String nom, String adresse, String photo,Integer distance) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.photo = photo;
		this.liked = liked;
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

	public Boolean getLiked() {
		return liked;
	}

	public void setLiked(Boolean liked) {
		this.liked = liked;
	}
	
}
