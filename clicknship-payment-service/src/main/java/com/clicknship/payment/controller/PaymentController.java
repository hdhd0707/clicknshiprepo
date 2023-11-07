package com.clicknship.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clicknship.common.controller.BaseController;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.common.exception.EmBusinessError;

@RestController
@RequestMapping(value = "/payment")
@RefreshScope
public class PaymentController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@GetMapping("/payByPayNow")
	public ResponseEntity<Void> payByPayNow() throws BusinessException {
		throw new BusinessException(EmBusinessError.PAYNOW_SERVICE_NOT_AVAILABLE);
	}

	@GetMapping("/payByCard")
	public ResponseEntity<Void> payByCard() {
		return ResponseEntity.ok().build();
	}
}
