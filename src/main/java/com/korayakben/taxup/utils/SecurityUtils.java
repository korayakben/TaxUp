package com.korayakben.taxup.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtils {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String hashPassword(String raw_password) {
		return passwordEncoder.encode(raw_password);
	}

	
	public boolean passwordsMatch(String raw_password, String hashed_password) {
		return passwordEncoder.matches(raw_password, hashed_password) ? true : false;
	}
}
