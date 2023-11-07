package com.clicknship.order.service.feign.fallback;

import org.springframework.http.ResponseEntity;

import com.clicknship.order.service.feign.PaymentService;
import com.clicknship.common.exception.BusinessException;

public class PaymentServiceFallback implements PaymentService {
	
	@Override
	public ResponseEntity<Void> payByPayNow() throws BusinessException {
		return ResponseEntity.badRequest().build(); 
	};
	
	@Override
	public ResponseEntity<Void> payByCard() {
		return ResponseEntity.badRequest().build(); 
	};

}
