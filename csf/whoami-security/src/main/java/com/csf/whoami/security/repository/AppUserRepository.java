package com.csf.whoami.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csf.whoami.security.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

	Optional<AppUser> findByEmail(String email);

	Boolean existsByEmail(String email);
}
