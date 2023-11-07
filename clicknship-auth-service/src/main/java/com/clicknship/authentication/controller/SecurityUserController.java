package com.clicknship.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clicknship.authentication.model.UserRegisterDTO;
import com.clicknship.authentication.service.UserAuthService;
import com.clicknship.common.controller.BaseController;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.user.UserDTO;
import com.clicknship.model.user.UserLoginDTO;

@RestController
@RequestMapping("/securityUser")
public class SecurityUserController extends BaseController {

	@Autowired
	private UserAuthService userAuthService;

	@PostMapping(value = "/register")
	public ResponseEntity<UserDTO> register(@RequestBody(required = true) UserRegisterDTO userRegister)
			throws BusinessException {
		return ResponseEntity.ok().body(userAuthService.registerUser(userRegister));
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<Boolean> login(@RequestBody(required = true) UserLoginDTO userDetails)
			throws BusinessException {
		return ResponseEntity.ok().body(userAuthService.loginUser(userDetails));
	}
	
	@GetMapping(value = "/is2faRequired")
	public ResponseEntity<Boolean> verifyIf2faIsRequired(@RequestParam(required = false) String username) throws BusinessException {
		return ResponseEntity.ok().body(userAuthService.verifyIf2faIsRequired(username));
	}
	
	@PostMapping(value = "/update2fa")
	public ResponseEntity<String> update2fa(@RequestBody(required = true) UserRegisterDTO userRegister)
			throws BusinessException {
		return ResponseEntity.ok().body(userAuthService.updateUser2fa(userRegister));
	}
}
