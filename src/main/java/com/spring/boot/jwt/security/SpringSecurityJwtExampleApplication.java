package com.spring.boot.jwt.security;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.jwt.security.model.User;
import com.spring.boot.jwt.security.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication 
{
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUsers()
	{
		List<User> users = Stream.of(new User(101,"Tester","tester","TesterWithUs@gmal.com")
				,new User(102,"SysAdmin","sysadmin","SysAdminWithUs@gmal.com")
				,new User(103,"Administrator","admin","AdministratorWithUs@gmal.com")
				,new User(104,"Developer","developer","DeveloperWithUs@gmal.com")
				).collect(Collectors.toList());
		
		userRepository.saveAll(users);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
