package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;


public enum ReservationState {

    //7 리팩토리 - 4.상태 값을 명확하게 enum으로 관리
    PENDING,
    APPROVED,
    CANCELED,
    EXPIRED;

}
