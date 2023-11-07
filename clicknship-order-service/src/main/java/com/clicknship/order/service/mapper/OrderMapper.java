package com.clicknship.order.service.mapper;

import org.mapstruct.Mapper;

import com.clicknship.order.entity.Order;
import com.clicknship.model.order.OrderDTO;

@Mapper(componentModel = "spring", uses = { OrderDetailMapper.class })
public interface OrderMapper {

	public OrderDTO toDto(Order order);
	
	public Order toEntity(OrderDTO orderDTO);
}
