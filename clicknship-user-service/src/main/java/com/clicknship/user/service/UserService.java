package com.clicknship.user.service;

import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.user.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO user) throws BusinessException;
	
	UserDTO getUserById(Long userId) throws BusinessException;

}
