package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class UserDTO {
    private BigDecimal totalExpenses;
}
