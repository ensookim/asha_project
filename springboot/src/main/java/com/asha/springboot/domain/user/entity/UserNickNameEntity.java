package com.asha.springboot.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 사용자 ID와 비밀번호 이외의 정보를 위한 엔티티
 */
@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserNickNameEntity {

    @Id // primary key(기본키) 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 index 증가
    private Long nicknameId;

    @Column(name = "nickname", unique = true) // nickname은 unique(단일 조건)
    private String nickname;

    @OneToOne // 1:1 단방향을 위해 UserEntity의 userEntity를 참조 (외래키)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Builder
    public UserNickNameEntity(Long nicknameId, String nickname, UserEntity userEntity) {
        this.nicknameId = nicknameId;
        this.nickname = nickname;
        this.userEntity = userEntity;
    }
}
