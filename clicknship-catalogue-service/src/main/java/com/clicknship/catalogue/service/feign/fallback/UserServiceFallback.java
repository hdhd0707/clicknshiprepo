package com.clicknship.catalogue.service.feign.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.clicknship.catalogue.service.feign.UserService;
import com.clicknship.model.user.UserDTO;

@Component
public class UserServiceFallback implements UserService {

	@Override
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId) {
		return ResponseEntity.badRequest().body(null); 
	}

}
