package com.csf.whoami.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csf.whoami.security.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
