package com.clicknship.user.service.mapper;

import org.mapstruct.Mapper;

import com.clicknship.model.user.UserDTO;
import com.clicknship.user.entity.User;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {

	public UserDTO toDto(User user);
	
	public User toEntity(UserDTO user);
}
