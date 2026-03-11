package com.dev.developer_management_system.domain.user_mst.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.dev.developer_management_system.domain.project_history.entity.ProjectHistoryEntity;
import com.dev.developer_management_system.domain.skills.entity.SkillEntity;
import com.dev.developer_management_system.domain.user_mst.entity.UserMstEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserMstDto
 * 개발자(User) 관련 DTO 클래스
 */
public class UserMstDto {

    /* =========================================================
     * Request DTO (개발자 등록)
     * ========================================================= */
    /**
     * 개발자 등록 요청 DTO
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserMstCreateRequestDto {

        private String userNm;
        private Integer userAge;
        private Integer empNo;
        private String userPhoneNo;
        private String userGrade;
        private String userAddr;
        private String userGender;
        private String userRank;
        private String workerRole;
        private String useYn;
        
        @Schema(example = "2026-03-11T16:30:00", description = "입사일")
        private LocalDateTime joinDt;

        /**
         * 개발자 스킬 목록
         */
        private List<UserSkillCreateRequestDto> skills;

        /**
         * DTO → Entity 변환
         */
        public UserMstEntity toEntity() {

            return UserMstEntity.builder()
                    .userNm(userNm)
                    .userAge(userAge)
                    .empNo(empNo)
                    .userPhoneNo(userPhoneNo)
                    .userGrade(userGrade)
                    .userAddr(userAddr)
                    .userGender(userGender)
                    .userRank(userRank)
                    .workerRole(workerRole)
                    .useYn(useYn)
                    .joinDt(joinDt)
                    .build();
        }
    }

    /**
     * 개발자 스킬 등록 요청 DTO
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserSkillCreateRequestDto {

        private String language;
        private String grade;

        /**
         * DTO → Entity 변환
         */
        public SkillEntity toEntity(UserMstEntity user) {

            SkillEntity skill = new SkillEntity();

            skill.setLanguage(language);
            skill.setGrade(grade);

            /**
             * FK 설정
             */
            skill.setUser(user);

            return skill;
        }
    }

    /* =========================================================
     * Response DTO
     * ========================================================= */
    /**
     * 개발자 List 응답 DTO
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserMstResponseDto {

        private Long userNo;
        private String userNm;
        private Integer userAge;
        private Integer empNo;
        private String userPhoneNo;
        private String userGrade;
        private String userAddr;
        private String userGender;
        private String userRank;
        private String workerRole;
        private String useYn;
        private LocalDateTime joinDt;
        private LocalDateTime regDt;
        private LocalDateTime updDt;

        /**
         * Entity → DTO 변환
         */
        public static UserMstResponseDto fromEntity(UserMstEntity user) {
            return UserMstResponseDto.builder()
                    .userNo(user.getUserNo())
                    .userNm(user.getUserNm())
                    .userAge(user.getUserAge())
                    .empNo(user.getEmpNo())
                    .userPhoneNo(user.getUserPhoneNo())
                    .userGrade(user.getUserGrade())
                    .userAddr(user.getUserAddr())
                    .userGender(user.getUserGender())
                    .userRank(user.getUserRank())
                    .workerRole(user.getWorkerRole())
                    .useYn(user.getUseYn())
                    .joinDt(user.getJoinDt())
                    .regDt(user.getRegDt())
                    .updDt(user.getUpdDt())
                    .build();
        }
    }

     /**
     * 개발자 상세 응답 DTO
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserMstDetailResponseDto {

        private Long userNo;
        private String userNm;
        private Integer userAge;
        private String userPhoneNo;
        private String userGrade;
        private String userAddr;
        private String userGender;
        private String userRank;
        private String workerRole;
        private String useYn;
        private LocalDateTime regDt;
        private LocalDateTime updDt;

        private List<SkillEntity> skills;
        private List<ProjectHistoryEntity> projectHistories;

        /**
         * Entity → DTO 변환 (Detail)
         */
        public static UserMstDetailResponseDto fromEntity(UserMstEntity user) {

            return UserMstDetailResponseDto.builder()
                    .userNo(user.getUserNo())
                    .userNm(user.getUserNm())
                    .userAge(user.getUserAge())
                    .userPhoneNo(user.getUserPhoneNo())
                    .userGrade(user.getUserGrade())
                    .userAddr(user.getUserAddr())
                    .userGender(user.getUserGender())
                    .userRank(user.getUserRank())
                    .workerRole(user.getWorkerRole())
                    .useYn(user.getUseYn())
                    .regDt(user.getRegDt())
                    .updDt(user.getUpdDt())
                    .skills(user.getSkills())
                    .projectHistories(user.getProjectHistories())
                    .build();
        }
    }
    
}