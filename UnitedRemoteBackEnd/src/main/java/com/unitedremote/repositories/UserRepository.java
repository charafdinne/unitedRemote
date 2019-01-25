package com.unitedremote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitedremote.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
