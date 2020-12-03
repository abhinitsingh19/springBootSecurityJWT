package com.spring.boot.jwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jwt.security.filter.JwtFilter;
import com.spring.boot.jwt.security.model.AuthReq;
import com.spring.boot.jwt.security.util.JwtUtil;

@RestController
public class SecurityController 
{

	@Autowired
	private JwtUtil util;
	@Autowired
	private AuthenticationManager manager;
	
	
	@GetMapping("/")
	public String springSecurity()
	{
		return "Welcome to spring security, this is my fist secured end point through jwt";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthReq authReq) throws Exception
	{
		try {
		manager.authenticate(new UsernamePasswordAuthenticationToken
				(authReq.getUserName(), authReq.getPassword()));
		}
		catch(Exception e)
		{
			throw new Exception("Invalid user Name And Password");
		}
		return util.generateToken(authReq.getUserName());
		
	}
}
