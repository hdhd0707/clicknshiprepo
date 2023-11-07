package com.clicknship.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clicknship.authentication.model.entity.SecurityUser;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long>{

	SecurityUser findByUsername(String username);

}
