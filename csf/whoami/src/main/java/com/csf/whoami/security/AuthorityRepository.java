package com.csf.whoami.security;


import org.springframework.data.jpa.repository.JpaRepository;

import whoami.common.domain.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {
}
