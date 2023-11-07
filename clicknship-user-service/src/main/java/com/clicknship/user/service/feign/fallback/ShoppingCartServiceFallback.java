package com.clicknship.user.service.feign.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.clicknship.model.cart.ShoppingCartDTO;
import com.clicknship.user.service.feign.ShoppingCartService;

@Component
public class ShoppingCartServiceFallback implements ShoppingCartService {

	@Override
	public ResponseEntity<ShoppingCartDTO> createCartForUser(ShoppingCartDTO user) {
		return ResponseEntity.badRequest().body(null); 
	}

}
