package com.clicknship.authentication.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.clicknship.authentication.model.UserRegisterDTO;
import com.clicknship.authentication.model.entity.SecurityUser;
import com.clicknship.model.user.UserDTO;

@Mapper(componentModel = "spring", uses = {})
public interface UserRegisterMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "expiry", ignore = true)
	public UserDTO toUserDto(UserRegisterDTO user);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "userId", ignore = true)
	@Mapping(target = "enabled", ignore = true)
	@Mapping(target = "authorities", ignore = true)
	public SecurityUser toSecurityUser(UserRegisterDTO user);
}
