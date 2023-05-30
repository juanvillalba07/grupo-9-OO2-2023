package com.unla.smartcity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptPasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("admin"));
		
		BCryptPasswordEncoder pe1 = new BCryptPasswordEncoder();
		System.out.println(pe1.encode("audi"));
		
	}

}
