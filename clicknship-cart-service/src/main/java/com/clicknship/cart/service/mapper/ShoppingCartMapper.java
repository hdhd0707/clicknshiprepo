package com.clicknship.cart.service.mapper;

import org.mapstruct.Mapper;

import com.clicknship.cart.entity.ShoppingCart;
import com.clicknship.model.cart.ShoppingCartDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ShoppingCartMapper {

	public ShoppingCartDTO toDto(ShoppingCart shoppingCart);
	
	public ShoppingCart toEntity(ShoppingCartDTO shoppingCartDTO);
}
