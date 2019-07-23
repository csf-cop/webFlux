/**
 * 
 */
package com.csf.whoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csf.whoami.entity.UserGroupEntity;

/**
 * @author tuan
 *
 */
@Repository
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {

}