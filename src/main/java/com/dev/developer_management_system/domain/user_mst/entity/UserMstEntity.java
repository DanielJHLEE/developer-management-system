package com.dev.developer_management_system.domain.user_mst.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.dev.developer_management_system.domain.project_history.entity.ProjectHistoryEntity;
import com.dev.developer_management_system.domain.skills.entity.SkillEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USER_MST")
public class UserMstEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "user_nm", nullable = false)
    private String userNm;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "user_phone_no")
    private String userPhoneNo;

    @Column(name = "user_grade")
    private String userGrade;
    
    @Column(name = "user_addr")
    private String userAddr;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_rank")
    private String userRank;

    @Column(name = "worker_role")
    private String workerRole;

    @Column(name = "use_yn")
    private String useYn;

    /**
     * 개발자 스킬 목록
     *
     * ERD 관계
     * TB_USER_MST (1) : (N) TB_USER_SKILL
     *
     * 개발자 1명이 여러 개의 개발 스킬을 가질 수 있음
     * TB_USER_SKILL.user_no 와 매핑되는 관계
     *
     * mappedBy = "user"
     * → SkillEntity의 user 필드가 연관관계의 주인
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
           cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SkillEntity> skills;

    /**
     * 프로젝트 투입 이력 목록
     * 
     * ERD 관계
     * TB_USER_MST (1) : (N) TB_INPUT_HIST
     * 
     * 개발자 1명은 여러 프로젝트에 투입될 수 있으므로
     * TB_INPUT_HIST.user_no 와 매핑되는 관계
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
           cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectHistoryEntity> projectHistories;

    @Column(name = "join_dt")
    private LocalDateTime joinDt;

    @CreationTimestamp
    @Column(name = "reg_dt", columnDefinition = "datetime")
    private LocalDateTime regDt;

    @Column(name = "upd_dt", columnDefinition = "datetime")
    private LocalDateTime updDt;
}