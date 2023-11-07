package com.clicknship.cart.repository;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clicknship.cart.CartApplication;
import com.clicknship.cart.entity.ShoppingCartProduct;
import com.clicknship.cart.repository.ShoppingCartProductRepository;

@SpringBootTest(classes = CartApplication.class)
class ShoppingCartProductRepositoryTest {

	@Autowired
	private ShoppingCartProductRepository shoppingCartProductRepository;
	
	@Test
	void test() {
		List<ShoppingCartProduct> result = shoppingCartProductRepository.findAll();
		assertNotEquals(0, result.size());
	}
}
