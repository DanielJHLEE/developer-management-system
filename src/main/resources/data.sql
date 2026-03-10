SET FOREIGN_KEY_CHECKS = 0; /* 외래키 체크 비활성화 */

TRUNCATE TABLE TB_INPUT_HIST;
TRUNCATE TABLE TB_USER_SKILL;
TRUNCATE TABLE TB_PRJ_MST;
TRUNCATE TABLE TB_USER_MST;
TRUNCATE TABLE TB_COM_CODE;

SET FOREIGN_KEY_CHECKS = 1; /* 외래키 체크 활성화 */

INSERT INTO TB_USER_MST
(user_nm, user_age, user_phone_no, user_grade, user_addr, user_gender, user_rank, worker_role, use_yn, reg_dt, upd_dt)
VALUES
('김개발', 29, '01012345678', 'A', '서울 강남구', '남', '정규직', '주임', 'Y', NOW(), NULL),
('이프론트', 32, '01023456789', 'B', '서울 마포구', '여', '비정규직', '대리', 'Y', NOW(), NULL),
('박백엔드', 35, '01034567890', 'A', '경기 성남시', '남', '정규직', '과장', 'Y', NOW(), NULL),
('최풀스택', 31, '01045678901', 'S', '인천 연수구', '여', '비정규직', '책임', 'Y', NOW(), NULL),
('정주니어', 26, '01056789012', 'C', '서울 관악구', '남', '정규직', '사원','Y', NOW(), NULL),
('한리액트', 28, '01067890123', 'B', '서울 서초구', '여', '정규직', '대리', 'Y', NOW(), NULL),
('오스프링', 34, '01078901234', 'A', '경기 수원시', '남', '정규직', '과장', 'Y', NOW(), NULL),
('유노드', 30, '01089012345', 'B', '서울 송파구', '남', '비정규직', '주임', 'Y', NOW(), NULL),
('장데브옵스', 37, '01090123456', 'S', '경기 고양시', '남', '정규직', '책임', 'Y', NOW(), NULL),
('문데이터', 33, '01001234567', 'A', '서울 용산구', '여', '정규직', '과장', 'Y', NOW(), NULL);


INSERT INTO TB_PRJ_MST
(prj_nm, prj_start_date, prj_end_date, prj_front_skill, prj_back_skill, orde_comp, perf_comp, cnc_prgrs_yn, reg_dt, upd_dt)
VALUES
('이커머스 플랫폼 구축','2024-01-01','2024-12-31','React','Spring Boot','쿠팡','CNC','N',NOW(),NULL),
('모바일 뱅킹 시스템','2023-06-01','2024-03-30','React Native','Spring','신한은행','CNC','Y',NOW(),NULL),
('물류관리 시스템','2024-02-01','2024-10-31','Vue','Node.js','CJ대한통운','CNC','N',NOW(),NULL),
('AI 추천 플랫폼','2024-03-01','2025-03-01','React','Python','네이버','CNC','N',NOW(),NULL),
('공공 포털 시스템','2023-09-01','2024-08-31','JSP','Spring','행정안전부','CNC','Y',NOW(),NULL);


INSERT INTO TB_USER_SKILL
(user_no, language, grade, reg_dt, upd_dt)
VALUES
(1,'Java','A',NOW(),NULL),
(1,'Spring','A',NOW(),NULL),
(2,'React','B',NOW(),NULL),
(2,'Javascript','B',NOW(),NULL),
(3,'Java','A',NOW(),NULL),
(3,'Spring Boot','A',NOW(),NULL),
(4,'React','S',NOW(),NULL),
(4,'Node.js','A',NOW(),NULL),
(5,'Java','C',NOW(),NULL),
(6,'React','B',NOW(),NULL),
(6,'Typescript','B',NOW(),NULL),
(7,'Spring','A',NOW(),NULL),
(7,'Java','A',NOW(),NULL),
(8,'Python','S',NOW(),NULL),
(8,'Django','A',NOW(),NULL),
(9,'Flutter','B',NOW(),NULL),
(10,'Tensorflow','S',NOW(),NULL);


INSERT INTO TB_INPUT_HIST
(prj_no, user_no, input_start_date, input_end_date, pm_yn, pl_yn, reg_dt, upd_dt)
VALUES
(1,1,'2024-01-01','2024-12-31','N','Y',NOW(),NULL),
(1,2,'2024-01-01','2024-12-31','N','N',NOW(),NULL),
(1,3,'2024-01-01','2024-12-31','Y','N',NOW(),NULL),
(2,4,'2023-06-01','2024-03-30','N','Y',NOW(),NULL),
(2,5,'2023-06-01','2024-03-30','N','N',NOW(),NULL),
(3,6,'2024-02-01','2024-10-31','N','N',NOW(),NULL),
(3,7,'2024-02-01','2024-10-31','Y','N',NOW(),NULL),
(4,8,'2024-03-01','2025-03-01','N','Y',NOW(),NULL),
(4,9,'2024-03-01','2025-03-01','N','N',NOW(),NULL),
(5,10,'2023-09-01','2024-08-31','Y','N',NOW(),NULL);

INSERT INTO TB_COM_CODE
(cd_group, cd_nm, cd_val, cd_val2, ord_no, use_yn, reg_dt, upd_dt)
VALUES
('GRADE','초급 개발자','C',NULL,1,'Y',NOW(),NULL),
('GRADE','중급 개발자','B',NULL,2,'Y',NOW(),NULL),
('GRADE','고급 개발자','A',NULL,3,'Y',NOW(),NULL),
('GRADE','특급 개발자','S',NULL,4,'Y',NOW(),NULL),

('LANG','Java','JAVA',NULL,1,'Y',NOW(),NULL),
('LANG','Spring','SPRING',NULL,2,'Y',NOW(),NULL),
('LANG','React','REACT',NULL,3,'Y',NOW(),NULL),
('LANG','Node.js','NODE',NULL,4,'Y',NOW(),NULL),
('LANG','Python','PYTHON',NULL,5,'Y',NOW(),NULL),

('ROLE','사원','STAFF',NULL,1,'Y',NOW(),NULL),
('ROLE','주임','ASSISTANT_MANAGER',NULL,2,'Y',NOW(),NULL),
('ROLE','대리','MANAGER',NULL,3,'Y',NOW(),NULL),
('ROLE','과장','SENIOR_MANAGER',NULL,4,'Y',NOW(),NULL),
('ROLE','책임','PRINCIPAL',NULL,5,'Y',NOW(),NULL);