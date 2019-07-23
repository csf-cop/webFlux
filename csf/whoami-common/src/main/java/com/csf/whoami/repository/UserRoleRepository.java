/**
 * 
 */
package com.csf.whoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csf.whoami.entity.UserRoleEntity;

/**
 * @author tuan
 *
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

}