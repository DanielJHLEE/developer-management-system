package com.dev.developer_management_system.domain.projects.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.dev.developer_management_system.domain.project_history.entity.ProjectHistoryEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_PRJ_MST")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prj_no")
    private Long prjNo;

    @Column(name = "prj_nm")
    private String prjNm;

    @Column(name = "prj_start_date")
    private LocalDate prjStartDate;

    @Column(name = "prj_end_date")
    private LocalDate prjEndDate;

    @Column(name = "prj_front_skill")
    private String prjFrontSkill;

    @Column(name = "prj_back_skill")
    private String prjBackSkill;

    @Column(name = "orde_comp")
    private String ordeComp;

    @Column(name = "perf_comp")
    private String perfComp;

    @Column(name = "cnc_prgrs_yn")
    private String cncPrgrsYn;

    /**
     * 프로젝트 투입 이력
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectHistoryEntity> projectHistories;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @Column(name = "upd_dt")
    private LocalDateTime updDt;
}