package com.dev.developer_management_system.domain.skills.entity;

import com.dev.developer_management_system.domain.user_mst.entity.UserMstEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "TB_USER_SKILL")
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_skill_no")
    private Long userSkillNo;

    /**
     * 개발자 스킬 목록
     * TB_USER_SKILL.user_no 와 매핑
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    @JsonIgnore
    private UserMstEntity user;

    @Column(name = "language")
    private String language;

    @Column(name = "grade")
    private String grade;

    @CreationTimestamp
    @Column(name = "reg_dt", columnDefinition = "datetime")
    private LocalDateTime regDt;

    @Column(name = "upd_dt", columnDefinition = "datetime")
    private LocalDateTime updDt;
}