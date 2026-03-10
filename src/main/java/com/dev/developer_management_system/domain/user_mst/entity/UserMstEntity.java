package com.dev.developer_management_system.domain.user_mst.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @Column(name = "upd_dt")
    private LocalDateTime updDt;
}