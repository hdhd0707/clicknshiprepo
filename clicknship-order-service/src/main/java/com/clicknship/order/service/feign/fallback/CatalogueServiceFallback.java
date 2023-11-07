package com.clicknship.order.service.feign.fallback;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.clicknship.order.service.feign.CatalogueService;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.cart.ShoppingCartProductDTO;

public class CatalogueServiceFallback implements CatalogueService {

	@Override
	public ResponseEntity<Void> deductProductStock(
			@PathVariable("id") @NotNull Long id,
			@RequestBody(required = true) @NotNull ShoppingCartProductDTO cartProduct) throws BusinessException {
		return ResponseEntity.badRequest().body(null); 
	}

	@Override
	public ResponseEntity<Void> returnProductStock(
			@PathVariable("id") @NotNull Long id, @PathVariable("returnedQuantity") @NotNull int quantity) throws BusinessException {
		return ResponseEntity.badRequest().body(null); 
	}
}
