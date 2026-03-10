package com.dev.developer_management_system.domain.project_history.entity;

import com.dev.developer_management_system.domain.projects.entity.ProjectEntity;
import com.dev.developer_management_system.domain.user_mst.entity.UserMstEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_INPUT_HIST")
public class ProjectHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "input_hist_no")
    private Long inputHistNo;

    /**
     * 프로젝트 FK
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prj_no")
    private ProjectEntity project;

    /**
     * 사용자 FK
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private UserMstEntity user;

    @Column(name = "input_start_date")
    private LocalDate inputStartDate;

    @Column(name = "input_end_date")
    private LocalDate inputEndDate;

    @Column(name = "pm_yn")
    private String pmYn;

    @Column(name = "pl_yn")
    private String plYn;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @Column(name = "upd_dt")
    private LocalDateTime updDt;
}