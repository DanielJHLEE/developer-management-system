package com.dev.developer_management_system.domain.user_mst.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

import com.dev.developer_management_system.domain.user_mst.entity.UserMstEntity;

/**
 * UserMstDto
 * 개발자(User) 관련 DTO 클래스
 */
public class UserMstDto {

    /**
     * 개발자 List / Detail 응답 DTO
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserMstResponseDto {

        private Long userNo;
        private String userNm;
        private Integer userAge;
        private String userPhoneNo;
        private String userGrade;
        private String userAddr;
        private String userGender;
        private String useYn;
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
                    .userPhoneNo(user.getUserPhoneNo())
                    .userGrade(user.getUserGrade())
                    .userAddr(user.getUserAddr())
                    .userAddr(user.getUserGender())
                    .useYn(user.getUseYn())
                    .regDt(user.getRegDt())
                    .updDt(user.getUpdDt())
                    .build();
        }
    }
}