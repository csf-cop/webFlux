/**
 * 
 */
package com.csf.whoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csf.whoami.entity.GroupEntity;

/**
 * @author tuan
 *
 */
@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, String> {

}