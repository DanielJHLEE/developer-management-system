package com.dev.developer_management_system.domain.com_code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_COM_CODE")
public class ComCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_no")
    private Long cdNo;

    @Column(name = "cd_group")
    private String cdGroup;

    @Column(name = "cd_nm")
    private String cdNm;

    @Column(name = "cd_val")
    private String cdVal;

    @Column(name = "cd_val2")
    private String cdVal2;

    @Column(name = "ord_no")
    private Integer ordNo;

    @Column(name = "use_yn")
    private String useYn;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @Column(name = "upd_dt")
    private LocalDateTime updDt;
}