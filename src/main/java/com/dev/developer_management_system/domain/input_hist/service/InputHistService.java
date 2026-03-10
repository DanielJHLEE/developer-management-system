package com.dev.developer_management_system.domain.input_hist.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dev.developer_management_system.domain.input_hist.dto.InputHistDto;
import com.dev.developer_management_system.domain.input_hist.repository.InputHistRepository;

import lombok.RequiredArgsConstructor;

/**
 * InputHistService
 * 개발자 투입 이력 관리 서비스
 */
@Service
@RequiredArgsConstructor
public class InputHistService {
    private final InputHistRepository inputHistRepository;

    public List<InputHistDto.InputHistResponseDto> getInputHistList() {
        return inputHistRepository.findAll().stream()
                .map(InputHistDto.InputHistResponseDto::fromEntity)
                .collect(Collectors.toList());
    }


}


