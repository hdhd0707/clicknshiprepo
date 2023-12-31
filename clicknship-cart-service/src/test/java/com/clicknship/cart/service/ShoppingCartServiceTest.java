package com.clicknship.cart.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clicknship.cart.CartApplication;
import com.clicknship.cart.entity.ShoppingCart;
import com.clicknship.cart.entity.ShoppingCartProduct;
import com.clicknship.cart.repository.ShoppingCartProductRepository;
import com.clicknship.cart.repository.ShoppingCartRepository;
import com.clicknship.cart.service.ShoppingCartService;
import com.clicknship.cart.service.impl.ShoppingCartServiceImpl;
import com.clicknship.cart.service.mapper.ShoppingCartMapper;
import com.clicknship.cart.service.mapper.ShoppingCartProductMapper;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.cart.ShoppingCartDTO;

@SpringBootTest(classes = CartApplication.class)
class ShoppingCartServiceTest {

	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Autowired
	private ShoppingCartProductMapper shoppingCartProductMapper;
	
	@Mock
	private ShoppingCartRepository shoppingCartRepository;
	@Mock
	private ShoppingCartProductRepository shoppingCartProductRepository;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		shoppingCartService = new ShoppingCartServiceImpl(shoppingCartRepository,
				shoppingCartProductRepository, shoppingCartMapper, shoppingCartProductMapper);
	}
	
	
	@Test
	void createShoppingCartTest1() {
		ShoppingCartDTO shoppingCartDTO = null;
		assertNull(shoppingCartService.createShoppingCart(shoppingCartDTO));
	}
	
	@Test
	void createShoppingCartTest2() {
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		shoppingCartDTO.setUserId(null);
		assertNull(shoppingCartService.createShoppingCart(shoppingCartDTO));
	}
	
	@Test
	void createShoppingCartTest3() {
		ShoppingCartDTO shoppingCartDTO = createShoppingCartDTO();
		Mockito.when(shoppingCartRepository.findByUserId(Mockito.anyLong())).thenReturn(Optional.empty());
		assertNull(shoppingCartService.createShoppingCart(shoppingCartDTO));
	}
	
	@Test
	void getShoppingCartTest1() {
		assertNull(shoppingCartService.getShoppingCartByUserId(null));
	}
	
	@Test
	void getShoppingCartTest2() {
		Mockito.when(shoppingCartRepository.findByUserId(Mockito.anyLong())).thenReturn(Optional.empty());
		assertNull(shoppingCartService.getShoppingCartByUserId(null));
	}
	
	@Test
	void getShoppingCartTest3() {
		ShoppingCart shoppingCart = createShoppingCart();
		Mockito.when(shoppingCartRepository.findByUserId(Mockito.anyLong())).thenReturn(Optional.of(shoppingCart));
		assertNotNull(shoppingCartService.getShoppingCartByUserId(null));
	}
	
	@Test
	void getShoppingCartProductTest1() throws BusinessException {
		assertFalse(shoppingCartService.getShoppingCartProduct(null).isPresent());
	}
	
	@Test
	void getShoppingCartProductTest2() throws BusinessException {
		Mockito.when(shoppingCartProductRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertFalse(shoppingCartService.getShoppingCartProduct(123l).isPresent());
	}
	
	@Test
	void getShoppingCartProductTest3() throws BusinessException {
		ShoppingCartProduct shoppingCartProduct = createShoppingCartProduct();
		Mockito.when(shoppingCartProductRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(shoppingCartProduct));
		assertNotNull(shoppingCartService.getShoppingCartProduct(123l));
	}
	
	ShoppingCartDTO createShoppingCartDTO() {
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		shoppingCartDTO.setId(3l);
		shoppingCartDTO.setUserId(3l);
		shoppingCartDTO.setDiscount(new BigDecimal(1));
		shoppingCartDTO.setPrice(new BigDecimal(1));
		return shoppingCartDTO;
	}
	
	ShoppingCartProduct createShoppingCartProduct() {
		ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();
		shoppingCartProduct.setId(3l);
		shoppingCartProduct.setProductId(3l);
		shoppingCartProduct.setQuantity(1);
		shoppingCartProduct.setShoppingCartId(1l);
		return shoppingCartProduct;
	}
	
	ShoppingCart createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId(1l);
		shoppingCart.setPrice(new BigDecimal(1));
		shoppingCart.setUserId(1l);
		shoppingCart.setDiscount(new BigDecimal(1));
		return shoppingCart;
	}
}
