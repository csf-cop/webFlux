package com.csf.whoamisecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.csf.whoamisecurity.domain.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {
}
