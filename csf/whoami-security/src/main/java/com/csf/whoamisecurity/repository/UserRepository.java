package com.csf.whoamisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csf.whoamisecurity.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) = LOWER(:username)")
    UserEntity findByUsernameCaseInsensitive(@Param("username") String username);

    @Query
    UserEntity findByEmail(String email);

    @Query
    UserEntity findByEmailAndActivationKey(String email, String activationKey);

    @Query
    UserEntity findByEmailAndResetPasswordKey(String email, String resetPasswordKey);

}