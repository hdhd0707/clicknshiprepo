package com.clicknship.catalogue.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.clicknship.catalogue.entity.Product;
import com.clicknship.model.product.ProductDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper {

	@Mapping(target = "productReviews", ignore = true)
	public ProductDTO toDto(Product product);
	
	public Product toEntity(ProductDTO product);
}
