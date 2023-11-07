package com.clicknship.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clicknship.common.exception.BusinessException;
import com.clicknship.common.exception.EmBusinessError;
import com.clicknship.model.cart.ShoppingCartDTO;
import com.clicknship.model.user.UserDTO;
import com.clicknship.user.entity.User;
import com.clicknship.user.repository.UserRepository;
import com.clicknship.user.service.UserService;
import com.clicknship.user.service.feign.ShoppingCartService;
import com.clicknship.user.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Override
	public UserDTO createUser(UserDTO user) throws BusinessException {
		User savedUser = userRepository.saveAndFlush(userMapper.toEntity(user));
		ShoppingCartDTO cart = new ShoppingCartDTO();
		cart.setUserId(savedUser.getId());
		ResponseEntity<ShoppingCartDTO> response = shoppingCartService.createCartForUser(cart);
		if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
			throw new BusinessException(EmBusinessError.SERVICE_NOT_AVAILABLE);
		}
		return userMapper.toDto(savedUser);
	}
	
	@Override
	public UserDTO getUserById(Long userId) throws BusinessException {
		Optional<User> savedUser = userRepository.findById(userId);
		if (!savedUser.isPresent()) {
			throw new BusinessException(EmBusinessError.USER_NOT_EXIST); 
		}
		return userMapper.toDto(savedUser.get());
	}

}
