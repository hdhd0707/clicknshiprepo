package com.clicknship.catalogue.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.clicknship.catalogue.entity.ProductReview;
import com.clicknship.model.product.ProductReviewDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductReviewMapper {

	@Mapping(target = "product", ignore = true)
	public ProductReviewDTO toDto(ProductReview productReview);
	
	public ProductReview toEntity(ProductReviewDTO productReview);
}
