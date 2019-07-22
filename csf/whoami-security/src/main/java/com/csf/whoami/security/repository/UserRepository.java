/**
 * 
 */
package com.csf.whoami.security.repository;

import java.util.Optional;

/**
 * @author mba0051
 *
 */
//import com.example.springsocial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csf.whoami.security.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByEmail(String email);

	Boolean existsByEmail(String email);

}