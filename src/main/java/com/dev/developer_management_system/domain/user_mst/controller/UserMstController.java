package com.dev.developer_management_system.domain.user_mst.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import com.dev.developer_management_system.domain.user_mst.dto.UserMstDto;
import com.dev.developer_management_system.domain.user_mst.service.UserMstService;

/**
 * UserMstController
 * 개발자 인력 관리 API Controller
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user-mst")
public class UserMstController {

    private final UserMstService userMstService;

    /**
     * 개발자 목록 조회
     * GET /userMst/list
     */
    @GetMapping("/list")
    public List<UserMstDto.UserMstResponseDto> getUserMstList() {
        return userMstService.getUserMstList();
    }

}