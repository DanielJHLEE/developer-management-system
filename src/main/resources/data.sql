TRUNCATE TABLE TB_USER_MST;

INSERT INTO TB_USER_MST
(user_nm, user_age, user_phone_no, user_grade, user_addr, user_gender, user_rank, worker_role, use_yn, reg_dt, upd_dt)
VALUES
('김개발', 29, '01012345678', 'A', '서울 강남구', '남', '정규직', '주임', 'Y', NOW(), NULL),
('이프론트', 32, '01023456789', 'B', '서울 마포구', '여', '비정규직', '대리', 'Y', NOW(), NULL),
('박백엔드', 35, '01034567890', 'A', '경기 성남시', '남', '정규직', '과장', 'Y', NOW(), NULL),
('최풀스택', 31, '01045678901', 'S', '인천 연수구', '여', '비정규직', '책임', 'Y', NOW(), NULL),
('정주니어', 26, '01056789012', 'C', '서울 관악구', '남', '정규직', '사원','Y', NOW(), NULL);