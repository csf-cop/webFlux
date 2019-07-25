/**
 * 
 */
package com.csf.whoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.csf.whoami.entity.UserEntityHT;

/**
 * @author tuan
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntityHT, String> {

	UserEntityHT findByEmail(String email);

	@Query(value = "select us from UserEntity us where (us.userName= :username or us.email= :username) and us.userPassword= :password")
	UserEntityHT findByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

	UserEntityHT findByUserName(String username);
}