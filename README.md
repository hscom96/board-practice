# 11st X 중고마켓

## Get started

> Demo 페이지 확인을 위해 프론트엔드와 백엔드 서버를 로컬에서 실행해주세요!



### 🌈 프론트엔드 데모 방법

##### 1. `frontend/` 디렉토리를 열어주세요

##### 2. 아래 명령어를 실행해주세요

```bash
// node 버전: v16.13.x

// 의존성 패키지 설치
npm install

// 프론트엔드 서버 실행
npm run dev
```

![test11](README.assets/test11.jpeg)



### 📌 백엔드 데모 방법

##### 1. MySQL 설정
- 스키마 'board' 생성

##### 2. Springboot 환경 설정

- DB관련 `application.yml` 값 설정 필요
```yml
  datasource:
    url: jdbc:mysql://localhost:3306/board?autoReconnect=true  # DB URL 설정 필요
    username: # DB username 설정필요
    password:  # DB password 설정필요
    driverClassName: com.mysql.cj.jdbc.Driver
```

##### 3. Springboot 어플리케이션 실행

![cat-typing](README.assets/cat-typing.jpeg)
