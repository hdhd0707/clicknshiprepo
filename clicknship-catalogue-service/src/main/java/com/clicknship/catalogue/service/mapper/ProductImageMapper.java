package com.clicknship.catalogue.service.mapper;

import org.mapstruct.Mapper;

import com.clicknship.catalogue.entity.ProductImage;
import com.clicknship.model.product.ProductImageDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductImageMapper {

	public ProductImageDTO toDto(ProductImage productImage);
	
	public ProductImage toEntity(ProductImageDTO productImage);
}
