# 11st-board-practice


## 백엔드 데모 방법

#### 1. MySQL 설정
- 스키마 'board' 생성

#### 2. Springboot 환경 설정
- MySQL Dependencies 설정
```gradle
implementation 'mysql:mysql-connector-java'
```
- DB관련 `application.yml` 값 설정 필요
```yml
  datasource:
    url: jdbc:mysql://localhost:3306/board?autoReconnect=true  # DB URL 설정 필요
    username: # DB username 설정필요
    password:  # DB password 설정필요
    driverClassName: com.mysql.cj.jdbc.Driver
```

#### 3. Springboot 어플리케이션 실행

