package com.clicknship.catalogue.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clicknship.catalogue.entity.ProductReview;
import com.clicknship.model.product.ProductRatingsDTO;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long>, JpaSpecificationExecutor<ProductReview> {
//	List<ProductReview> findAllByProductId(Long productId);
	
	Page<ProductReview> findAllByProductId(Long productId, Pageable page);
	
	@Query("SELECT new com.clicknship.model.product.ProductRatingsDTO(SUM(pr.rating), COUNT(*)) "
			+ "From ProductReview pr where pr.product.id = :productId")
	ProductRatingsDTO findProductRatings(Long productId);
}
