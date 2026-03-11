# BE-developer-management-system
개발자 인력 관리 프로젝트

Spring Boot, JPA, Gradle, Swagger UI를 사용하여 개발자 인력 정보를 관리하는 API

---

# 개발 환경 Backend

- Java (JDK 17)
- Spring Boot 3.x
- Spring Data JPA
- Lombok
- Gradle
- Swagger (Springdoc OpenAPI)

---

# GRADLE 명령어 빌드/실행

프로젝트 빌드

```
./gradlew clean build
./gradlew build --refresh-dependencies
```

- `clean build` : 기존 빌드 산출물을 삭제한 후 프로젝트를 전체 빌드합니다.  
- `--refresh-dependencies` : Gradle 캐시를 무시하고 의존성을 다시 다운로드하여 빌드합니다.

프로젝트 실행

```
./gradlew bootRun
```

- Spring Boot 애플리케이션을 실행합니다.

테스트 API

```
http://localhost:8080/userMst/list
```

Swagger API URL

```
http://localhost:8080/swagger-ui/index.html#/
```

---

# 프로젝트 구조

```
src
 └ main
     └ java
         └ com.dev.developer_management_system
             └ domain
                 └ user_mst
                     ├ controller
                     │    └ UserMstController
                     │
                     ├ service
                     │    └ UserMstService
                     │
                     ├ repository
                     │    └ UserMstRepository
                     │
                     ├ entity
                     │    └ UserMstEntity
                     │
                     └ dto
                          └ UserMstDto
```

레이어 구조

```
Controller
   ↓
Service
   ↓
Repository (JPA)
   ↓
Database
```

---

# ERD (Database Structure)

### TB_USER_MST
개발자 기본 정보

| Column | Description |
|------|------|
user_no | 유저 식별 키 (PK)
user_nm | 개발자 이름
user_age | 나이
user_phone_no | 휴대폰 번호
user_grade | 개발자 등급
user_addr | 주소
user_gender | 성별
user_rank | 고용 형태
worker_role | 직급
use_yn | 사용 여부 (입/퇴사)
reg_dt | 등록일
upd_dt | 수정일

개발자 기본 정보를 관리하는 테이블이며 다른 테이블의 기준이 되는 **마스터 테이블**입니다.

---

### TB_USER_SKILL
개발자 보유 기술

| Column | Description |
|------|------|
user_skill_no | 스킬 식별 키 (PK)
user_no | 유저 참조 키 (FK)
language | 개발 언어
grade | 언어 숙련도
reg_dt | 등록일
upd_dt | 수정일

개발자가 보유한 기술 정보를 관리하는 테이블입니다.

**관계**

```
TB_USER_MST (1) : (N) TB_USER_SKILL
```

개발자 한 명이 여러 기술을 가질 수 있습니다.

---

### TB_PRJ_MST
프로젝트 정보

| Column | Description |
|------|------|
prj_no | 프로젝트 식별 키 (PK)
prj_nm | 프로젝트 이름
prj_start_date | 프로젝트 시작일
prj_end_date | 프로젝트 종료일
prj_front_skill | 프론트 요구 기술
prj_back_skill | 백엔드 요구 기술
orde_comp | 발주처
perf_comp | 수행처
cnc_prgrs_yn | C&C 진행 여부
reg_dt | 등록일
upd_dt | 수정일

프로젝트 기본 정보를 관리하는 테이블입니다.

---

### TB_INPUT_HIST
프로젝트 투입 이력

| Column | Description |
|------|------|
input_hist_no | 투입 이력 식별 키 (PK)
prj_no | 프로젝트 참조 키 (FK)
user_no | 유저 참조 키 (FK)
input_start_date | 투입 시작일
input_end_date | 투입 종료일
pm_yn | PM 여부
pl_yn | PL 여부
reg_dt | 등록일
upd_dt | 수정일

개발자의 프로젝트 투입 이력을 관리하는 테이블입니다.

**관계**

```
TB_USER_MST (1) : (N) TB_INPUT_HIST
TB_PRJ_MST (1) : (N) TB_INPUT_HIST
```

개발자 한 명은 여러 프로젝트에 투입될 수 있으며  
하나의 프로젝트에도 여러 개발자가 투입될 수 있습니다.

---

### TB_COM_CODE
공통 코드

| Column | Description |
|------|------|
cd_no | 코드 식별 키
cd_group | 코드 그룹
cd_nm | 코드 이름
cd_val | 코드 값
cd_val2 | 추가 코드 값
ord_no | 정렬 순서
use_yn | 사용 여부
reg_dt | 등록일
upd_dt | 수정일

공통 코드 데이터를 관리하기 위한 테이블입니다.

---

# MySQL Database Setup

이 문서는 Developer Management System 프로젝트 실행을 위한 MySQL 데이터베이스 설정 방법을 정리한 가이드입니다.

각 개발자는 로컬 환경에 MySQL을 설치하고 동일한 데이터베이스를 생성해야 합니다.

---

# 1. MySQL 설치

MySQL 공식 사이트에서 설치 프로그램을 다운로드합니다.

다운로드  
https://dev.mysql.com/downloads/installer/

다운로드 파일

```
mysql-installer-web-community
```

설치 실행 후 Setup Type에서 다음 옵션을 선택합니다.

```
Developer Default
```

이 옵션을 선택하면 개발 환경에 필요한 MySQL Server 및 관련 도구들이 함께 설치됩니다.

---

# 2. MySQL 접속

설치가 완료되면 터미널에서 다음 명령어로 MySQL에 접속합니다.

```
mysql -u root -p
```

설치 과정에서 설정한 root 비밀번호를 입력합니다.

정상적으로 접속되면 다음과 같은 화면이 표시됩니다.

```
mysql>
```

---

# 3. Spring Boot 데이터베이스 설정

이 프로젝트는 JDBC 옵션을 사용하여 데이터베이스를 자동 생성하도록 구성되어 있습니다.

application.yaml

```yaml
spring:
  application:
    name: developer-management-system

  datasource:
    url: jdbc:mysql://localhost:3306/dev_manage?createDatabaseIfNotExist=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8
    username: root
    password: 1234
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true
    defer-datasource-initialization: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect

  sql:
    init:
      mode: always

server:
  port: 8080
```

---

# 4. 데이터베이스 자동 생성 방식

프로젝트 실행 시 다음과 같은 순서로 동작합니다.

```
Spring Boot 실행
↓
MySQL 접속
↓
dev_manage 데이터베이스 존재 여부 확인
↓
없으면 자동 생성
↓
JPA Entity 기준 테이블 생성
↓
data.sql 실행
```

구조 예시

```
MySQL
 └ dev_manage
      ├ TB_USER_MST
      ├ TB_USER_SKILL
      ├ TB_PRJ_MST
      ├ TB_INPUT_HIST
      └ TB_COM_CODE
```

따라서 개발자는 MySQL만 설치하면 되고 별도의 DB 생성 작업은 필요 없습니다.

---

# 5. 초기 데이터 (data.sql)

프로젝트 실행 시 테스트 데이터를 자동으로 삽입합니다.

위치

```
src/main/resources/data.sql
```

테이블 초기화 및 데이터 삽입은 다음 순서로 진행됩니다.

### 1. 테이블 초기화 (외래키 FK 관계 고려)

```
1. TB_INPUT_HIST
2. TB_USER_SKILL
3. TB_PRJ_MST
4. TB_USER_MST
5. TB_COM_CODE
```

외래키(FK) 관계로 인해 하위 테이블부터 초기화됩니다.

### 2. 테스트 데이터 삽입

```
1. TB_USER_MST
2. TB_PRJ_MST
3. TB_USER_SKILL
4. TB_INPUT_HIST
5. TB_COM_CODE
```

참조 관계에 맞게 상위 테이블부터 데이터가 삽입됩니다.

예시

```sql
TRUNCATE TABLE TB_INPUT_HIST;
TRUNCATE TABLE TB_USER_SKILL;
TRUNCATE TABLE TB_PRJ_MST;
TRUNCATE TABLE TB_USER_MST;
TRUNCATE TABLE TB_COM_CODE;

INSERT INTO TB_USER_MST
(user_nm, user_age, user_phone_no, user_grade, user_addr, user_gender, use_yn, reg_dt, upd_dt)
VALUES
('김개발', 29, '01012345678', 'A', '서울 강남구', '남', 'Y', NOW(), NULL),
('이프론트', 32, '01023456789', 'B', '서울 마포구', '여', 'Y', NOW(), NULL),
('박백엔드', 35, '01034567890', 'A', '경기 성남시', '남', 'Y', NOW(), NULL),
('최풀스택', 31, '01045678901', 'S', '인천 연수구', '여', 'Y', NOW(), NULL),
('정주니어', 26, '01056789012', 'C', '서울 관악구', '남', 'Y', NOW(), NULL);
```

---

# Summary

프로젝트 실행 순서

1. MySQL 설치
2. Spring Boot 프로젝트 실행
3. dev_manage 데이터베이스 자동 생성
4. Entity 기반 테이블 자동 생성
5. data.sql 초기 데이터 삽입
6. API 테스트

이 프로젝트는 **JPA(Entity)를 기준으로 데이터베이스 구조를 관리하는 방식(Code First)** 을 사용합니다.
