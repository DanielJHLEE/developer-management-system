package com.dev.developer_management_system.domain.input_hist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.developer_management_system.docs.swagger.SwaggerTags;
import com.dev.developer_management_system.domain.input_hist.dto.InputHistDto;
import com.dev.developer_management_system.domain.input_hist.service.InputHistService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * InputHistController
 * 개발자 투입 이력 관리 API Controller
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/input-hist")
@Tag(name = SwaggerTags.INPUT_HIST_NAME, description = SwaggerTags.INPUT_HIST_DESC)
public class InputHistController {

    private final InputHistService inputHistService;

    /**
     * 투입 이력 목록 조회
     * GET /input-hist/list
     */
    @GetMapping("/list")
    public List<InputHistDto.InputHistResponseDto> getInputHistList() {
        return inputHistService.getInputHistList();
    }
}
