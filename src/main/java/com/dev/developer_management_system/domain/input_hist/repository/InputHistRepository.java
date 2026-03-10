package com.dev.developer_management_system.domain.input_hist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.developer_management_system.domain.project_history.entity.ProjectHistoryEntity;

@Repository
public interface InputHistRepository extends JpaRepository<ProjectHistoryEntity, Long> {
}
