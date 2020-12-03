package com.spring.boot.jwt.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.jwt.security.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{

	User findByUserName(String name);
	

}
