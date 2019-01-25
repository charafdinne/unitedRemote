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
public class UnitedRemoteBackEndApplication implements CommandLineRunner{

	@Autowired
	ShopRepository shopRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UnitedRemoteBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.shopRepository.save(new Shop("shop 1","assets/shop1.jpg","adresse shop 1",300));
		this.shopRepository.save(new Shop("shop 2","assets/shop2.jpg","adresse shop 2",200));
		this.shopRepository.save(new Shop("shop 3","assets/shop3.jpg","adresse shop 3",100));
		this.shopRepository.save(new Shop("shop 4","assets/shop4.jpg","adresse shop 4",500));
		this.shopRepository.save(new Shop("shop 5","assets/shop5.jpg","adresse shop 5",50));
		this.shopRepository.save(new Shop("shop 6","assets/shop6.jpg","adresse shop 6",10));
		this.shopRepository.save(new Shop("shop 7","assets/shop7.jpg","adresse shop 7",600));
		this.shopRepository.save(new Shop("shop 8","assets/shop8.jpg","adresse shop 8",200));
	}
	
}