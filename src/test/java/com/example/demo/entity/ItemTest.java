package com.example.demo.entity;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Item 엔티티")
class ItemTest {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Item 생성 시 기본 status 값 확인")
    void testDefaultStatusValue() {
        Item item = new Item("테스트 아이템", "설명", null, null);
        item = entityManager.persistAndFlush(item);

        assertEquals("PENDING", item.getStatus(), "기본 status 값은 'PENDING'이어야 합니다.");
    }

    @Test
    @DisplayName("status null 값 제약 조건 테스트")
    void testStatusNotNullConstraint() {
        Item item = new Item("테스트 아이템", "설명", null, null);
        item.setStatus(null);  // status를 null로 설정

        assertThrows(ConstraintViolationException.class, () -> {
            entityManager.persistAndFlush(item);
        }, "status가 null일 때 예외가 발생해야 합니다.");

    }
}
