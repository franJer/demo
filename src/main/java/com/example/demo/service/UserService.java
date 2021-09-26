package com.example.demo.service;

import java.math.BigDecimal;

public interface UserService {

    BigDecimal getTotalExpensesByUser(String userName);
}
