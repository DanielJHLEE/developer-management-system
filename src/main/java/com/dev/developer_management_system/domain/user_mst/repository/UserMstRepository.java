package com.dev.developer_management_system.domain.user_mst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.developer_management_system.domain.user_mst.entity.UserMstEntity;

/**
 * UserMstRepository
 * 개발자 인력 테이블 DB 접근 Repository
 */
@Repository
public interface UserMstRepository extends JpaRepository<UserMstEntity, Long> {

}