package com.dev.developer_management_system.domain.input_hist.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.dev.developer_management_system.domain.project_history.entity.ProjectHistoryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InputHistDto
 * 개발자 투입 이력(InputHist) 관련 DTO 클래스
 */
public class InputHistDto {
    /**
     * 개발자 List / Detail 응답 DTO
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InputHistResponseDto {

        private Long prjNo;
        private Long userNo;
        private LocalDate inputStartDate;
        private LocalDate inputEndDate;
        private String pmYn;
        private String plYn;
        private LocalDateTime regDt;
        private LocalDateTime updDt;

        /**
         * Entity → DTO 변환
         */
        public static InputHistResponseDto fromEntity(ProjectHistoryEntity hist) {
            return InputHistResponseDto.builder()
                    .prjNo(hist.getProject().getPrjNo())
                    .userNo(hist.getUser().getUserNo())
                    .inputStartDate(hist.getInputStartDate())
                    .inputEndDate(hist.getInputEndDate())
                    .pmYn(hist.getPmYn())
                    .plYn(hist.getPlYn())
                    .regDt(hist.getRegDt())
                    .updDt(hist.getUpdDt())
                    .build();
        }
    }
}
