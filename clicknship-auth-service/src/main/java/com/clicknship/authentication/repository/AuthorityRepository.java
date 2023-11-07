package com.clicknship.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clicknship.authentication.model.AuthorityName;
import com.clicknship.authentication.model.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findByName(AuthorityName name);
}
