package com.example.backend.model;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends AuditProperties {

    private static final Pattern PWD_PATTERN = Pattern.compile("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_login_at", nullable = false)
    private LocalDateTime lastLoginAt = LocalDateTime.now();

    @Builder
    public User(LocalDateTime createdAt, LocalDateTime modifiedAt, Long userId, String name,
        String userName, String userRole, String password, Long createdById,
        Long modifiedById, LocalDateTime lastLoginAt) {
        super(createdAt, modifiedAt, createdById, modifiedById);
        verifyPasswordForm(password);
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.userRole = userRole;
        this.password = password;
        this.lastLoginAt = lastLoginAt;
    }

    private void verifyPasswordForm(String password) {
        Matcher matcher = PWD_PATTERN.matcher(password);
        if(!matcher.find())
            throw new CustomException(ResponseCode.PWD_FORM_ERROR);
    }
}
