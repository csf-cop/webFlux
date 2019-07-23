/**
 * 
 */
package com.csf.whoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csf.whoami.entity.RolesEntity;

/**
 * @author tuan
 *
 */
@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
	RolesEntity findByRoleName(String roleName);
}