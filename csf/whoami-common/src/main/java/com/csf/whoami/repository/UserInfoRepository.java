/**
 * 
 */
package com.csf.whoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csf.whoami.entity.UserInfoEntity;

/**
 * @author tuan
 *
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

}