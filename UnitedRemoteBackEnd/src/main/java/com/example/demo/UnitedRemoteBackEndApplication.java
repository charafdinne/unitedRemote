package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.unitedremote.entities.Shop;
import com.unitedremote.repositories.ShopRepository;

@SpringBootApplication
@ComponentScan("com.unitedremote.web")
@EnableJpaRepositories("com.unitedremote.repositories")
@EntityScan("com.unitedremote.entities")
public class UnitedRemoteBackEndApplication {

	@Autowired
	ShopRepository shopRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UnitedRemoteBackEndApplication.class, args);
	}
}