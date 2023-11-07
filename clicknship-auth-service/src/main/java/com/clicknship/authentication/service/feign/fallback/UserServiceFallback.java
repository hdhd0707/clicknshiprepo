package com.clicknship.authentication.service.feign.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.clicknship.authentication.service.feign.UserService;
import com.clicknship.model.user.UserDTO;

@Component
public class UserServiceFallback implements UserService {

	@Override
	public ResponseEntity<UserDTO> register(UserDTO user) {
		return ResponseEntity.badRequest().body(null); 
	}

}
