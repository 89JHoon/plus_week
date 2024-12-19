package com.example.demo.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



@DisplayName("PasswordEncoder 테스트")
class PasswordEncoderTest {

    @Test
    @DisplayName("비밀번호 인코딩 테스트")
    void encode() {
        String rawPassword = "testPassword123";
        String encodePassword = PasswordEncoder.encode(rawPassword);

        assertNotNull(encodePassword);
        assertNotEquals(rawPassword,encodePassword);
        assertTrue(encodePassword.startsWith("$2a$"));

    }

    @Test
    @DisplayName("비밀번호 일치 확인 테스트")
    void matches() {
        String rawPassword = "testPassword123";
        String encodePassword = PasswordEncoder.encode(rawPassword);

        assertTrue(PasswordEncoder.matches(rawPassword,encodePassword));
        assertFalse(PasswordEncoder.matches("잘못된 비밀번호입니다.",encodePassword));

    }
}