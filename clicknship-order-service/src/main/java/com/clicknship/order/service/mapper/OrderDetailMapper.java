package com.clicknship.order.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.clicknship.order.entity.OrderDetail;
import com.clicknship.model.order.OrderDetailDTO;

@Mapper(componentModel = "spring", uses = {})
public interface OrderDetailMapper {

	@Mapping(target = "order", ignore = true)
	public OrderDetailDTO toDto(OrderDetail order);
	
	@Mapping(target = "order", ignore = true)
	public OrderDetail toEntity(OrderDetailDTO orderDTO);
	
	public List<OrderDetailDTO> toDto(List<OrderDetail> order);
	
	public List<OrderDetail> toEntity(List<OrderDetailDTO> orderDTO);
}
