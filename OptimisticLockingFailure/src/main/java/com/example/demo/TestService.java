package com.example.demo;


import org.springframework.stereotype.Service;

@Service	
public class TestService {
	
	public String test() throws Exception {
		throw new Exception();
	}
}
