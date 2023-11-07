package com.clicknship.authentication.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.clicknship.authentication.model.UserRegisterDTO;
import com.clicknship.authentication.model.UserTokenDTO;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.user.UserDTO;
import com.clicknship.model.user.UserLoginDTO;

public interface UserAuthService {
	
	boolean verifyIf2faIsRequired(String username) throws BusinessException;
	
	boolean loginUser(UserLoginDTO userDetails) throws BusinessException;
	
	UserTokenDTO handleLoginSuccess(OAuth2AccessToken userToken, String username) throws BusinessException;
	
	UserDTO registerUser(UserRegisterDTO userRegister) throws BusinessException;

	String updateUser2fa(UserRegisterDTO userRegister) throws BusinessException;
}
