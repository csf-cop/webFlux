package com.csf.whoami.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.csf.whoami.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

    @Query(value = "select us from UserEntity us where "
            + "(us.name = :username "
            + "or us.email = :username) ")
	Optional<UserEntity> findByUsername(@Param("username")String username);
}
