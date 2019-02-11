package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.unitedremote.entities.Shop;
import com.unitedremote.entities.User;
import com.unitedremote.repositories.RoleRepository;
import com.unitedremote.repositories.ShopRepository;
import com.unitedremote.repositories.UserRepository;

@EnableWebSecurity
@SpringBootApplication
@ComponentScan(basePackages = {"com.unitedremote.web","com.example.demo"})
@EnableJpaRepositories("com.unitedremote.repositories")
@EntityScan("com.unitedremote.entities")
public class UnitedRemoteBackEndApplication implements CommandLineRunner{

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UnitedRemoteBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//adding shops
		Shop shop1 = new Shop("shop 1","assets/shop1.jpg","adresse shop 1",300); 
		this.shopRepository.save(shop1);
		Shop shop2 = new Shop("shop 2","assets/shop2.jpg","adresse shop 2",200);
		this.shopRepository.save(shop2);
		this.shopRepository.save(new Shop("shop 3","assets/shop3.jpg","adresse shop 3",100));
		this.shopRepository.save(new Shop("shop 4","assets/shop4.jpg","adresse shop 4",500));
		this.shopRepository.save(new Shop("shop 5","assets/shop5.jpg","adresse shop 5",50));
		this.shopRepository.save(new Shop("shop 6","assets/shop6.jpg","adresse shop 6",10));
		this.shopRepository.save(new Shop("shop 7","assets/shop7.jpg","adresse shop 7",600));
		this.shopRepository.save(new Shop("shop 8","assets/shop8.jpg","adresse shop 8",200));
		
		//adding an admin user with it's  ADMIN ROLE
		User user = new User("charaf.boughriba.96@gmail.com", "{noop}admin", true);
		com.unitedremote.entities.Role role = new com.unitedremote.entities.Role("ADMIN","description role ADMIN");
		this.roleRepository.save(role);
		
		Set<com.unitedremote.entities.Role> roles = new HashSet<com.unitedremote.entities.Role>();
		roles.add(role);
		user.setRoles(roles);
		
		this.userRepository.save(user);
		
		user.getLikedShops().add(shop1);
		user.getLikedShops().add(shop2);
		
		this.userRepository.save(user);
	}
	
}