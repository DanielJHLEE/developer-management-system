# developer-management-system
개발자 인력 관리 프로젝트

Spring Boot, JPA, Gradle, Swagger UI를 사용하여 개발자 인력 정보를 관리하는 API

# 개발 환경 Backend
* Java (JDK 17)
* Spring Boot 3.x
* Spring Data JPA
* Lombok
* Gradle
* Swagger (Springdoc OpenAPI)

# GRADLE 명령어 빌드/실행
* ./gradlew clean build 빌드  
* ./gradlew bootRun 실행

* http://localhost:8080/developers/test
* http://localhost:8080/swagger-ui/index.html#/ (Swagger API URL)

...
# MySQL Database Setup

이 문서는 Developer Management System 프로젝트 실행을 위한 MySQL 데이터베이스 설정 방법을 정리한 가이드입니다.
각 개발자는 로컬 환경에 MySQL을 설치하고 동일한 데이터베이스를 생성해야 합니다.

# 1. MySQL 설치

MySQL 공식 사이트에서 설치 프로그램을 다운로드합니다.

다운로드
https://dev.mysql.com/downloads/installer/

다운로드 파일

mysql-installer-web-community

설치 실행 후 Setup Type에서 다음 옵션을 선택합니다.

Developer Default

이 옵션을 선택하면 개발 환경에 필요한 MySQL Server 및 관련 도구들이 함께 설치됩니다.

# 2. MySQL 접속
설치가 완료되면 터미널에서 다음 명령어로 MySQL에 접속합니다.

mysql -u root -p

설치 과정에서 설정한 root 비밀번호를 입력합니다.

정상적으로 접속되면 다음과 같은 화면이 표시됩니다.

mysql>

# 3. Spring Boot 데이터베이스 설정

이 프로젝트는 JDBC 옵션을 사용하여 데이터베이스를 자동 생성하도록 구성되어 있습니다.

application.yaml

spring:
  application:
    name: developer-management-system

  datasource:
    url: jdbc:mysql://localhost:3306/dev_management?createDatabaseIfNotExist=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8
    username: root
    password: 1234
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect

server:
  port: 8080

# 4. 데이터베이스 자동 생성 방식
프로젝트 실행 시 다음과 같은 순서로 동작합니다.

Spring Boot 실행
↓
MySQL 접속
↓
dev_management 데이터베이스 존재 여부 확인
↓
없으면 자동 생성
↓
JPA Entity 기준 테이블 생성

구조 예시

MySQL
 └ dev_management
      └ developer
      └ project
      └ assignment

따라서 개발자는 MySQL만 설치하면 되고 별도의 DB 생성 작업은 필요 없습니다.

# 5. 프로젝트 실행
Spring Boot 서버 실행

./gradlew bootRun

서버가 정상적으로 실행되면

dev_management 데이터베이스 자동 생성

JPA Entity 기반 테이블 자동 생성

이 이루어집니다.

# Summary

프로젝트 실행 순서

1. MySQL 설치
2. Spring Boot 프로젝트 실행
3. dev_management 데이터베이스 자동 생성
4. Entity 기반 테이블 자동 생성

이 프로젝트는 JPA(Entity)를 기준으로 데이터베이스 구조를 관리하는 방식(Code First)을 사용합니다.
