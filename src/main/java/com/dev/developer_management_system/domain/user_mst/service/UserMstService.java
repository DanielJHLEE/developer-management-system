package com.dev.developer_management_system.domain.user_mst.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dev.developer_management_system.domain.user_mst.dto.UserMstDto;
import com.dev.developer_management_system.domain.user_mst.entity.UserMstEntity;
import com.dev.developer_management_system.domain.user_mst.repository.UserMstRepository;

import lombok.RequiredArgsConstructor;

/**
 * UserMstService
 * 개발자 인력 관리 서비스
 */
@Service
@RequiredArgsConstructor
public class UserMstService {

    private final UserMstRepository userMstRepository;

    /**
     * 개발자 목록 조회
     */
    public List<UserMstDto.UserMstResponseDto> getUserMstList() {
        List<UserMstEntity> userMstList = userMstRepository.findAll();

        return userMstList.stream()
                .map(UserMstDto.UserMstResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}