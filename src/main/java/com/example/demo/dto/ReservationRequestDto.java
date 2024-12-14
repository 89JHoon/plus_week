package com.example.demo.dto;

import com.example.demo.entity.ReservationState;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationRequestDto {
    private Long itemId;
    private Long userId;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private ReservationState state;
}
