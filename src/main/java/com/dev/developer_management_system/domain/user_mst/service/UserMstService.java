package com.dev.developer_management_system.domain.user_mst.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.developer_management_system.domain.skills.entity.SkillEntity;
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

    /**
     * 개발자 상세 조회
     */
    public Optional<UserMstDto.UserMstDetailResponseDto> getUserMstDetail(Long userNo) {

        return userMstRepository.findById(userNo)
                .map(UserMstDto.UserMstDetailResponseDto::fromEntity);
    }

    /**
     * 개발자 삭제
     */
   @Transactional
    public boolean deleteUserMst(Long userNo) {

        Optional<UserMstEntity> userOpt = userMstRepository.findById(userNo);

        if (userOpt.isEmpty()) {
            return false;
        }

        UserMstEntity user = userOpt.get();

        user.getSkills().size();
        user.getProjectHistories().size();

        userMstRepository.delete(user);

        return true;
    }

    /**
     * 개발자 등록
     */
    @Transactional
    public void createUserMst(UserMstDto.UserMstCreateRequestDto requestDto) {

        // 1. User Entity 생성
        UserMstEntity user = requestDto.toEntity();

        // 2. Skill Entity 생성
        if (requestDto.getSkills() != null && !requestDto.getSkills().isEmpty()) {

            List<SkillEntity> skills = requestDto.getSkills()
                    .stream()
                    .map(skillDto -> skillDto.toEntity(user))
                    .collect(Collectors.toList());

            user.setSkills(skills);
        }

        // 3. 저장 (cascade로 skill 같이 저장)
        userMstRepository.save(user);
    }
}