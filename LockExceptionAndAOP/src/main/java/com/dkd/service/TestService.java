package com.dkd.service;

import org.springframework.stereotype.Service;

import com.dkd.annotation.IsTryAgain;

@Service
public class TestService {
	
	@IsTryAgain
	public String test() throws Exception {
		System.out.println(System.currentTimeMillis());
		throw new Exception();
	}
}
