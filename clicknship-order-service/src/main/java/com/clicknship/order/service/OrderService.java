package com.clicknship.order.service;

import java.util.List;
import java.util.Optional;

import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.order.CreateOrderDTO;
import com.clicknship.model.order.OrderDTO;
import com.clicknship.model.order.OrderSearchDTO;

public interface OrderService {
	List<OrderDTO> createOrder(CreateOrderDTO order) throws BusinessException;
	Optional<OrderDTO> findOrderById(Long id);
	void cancelPayment(List<Long> orderIds);
	void confirmPayment(String payOption, List<Long> orderIds) throws BusinessException;
	List<OrderDTO> searchOrders(OrderSearchDTO searchDTO);
	void orderReceived(OrderDTO order);
	void confirmDelivery(OrderDTO order);
}
