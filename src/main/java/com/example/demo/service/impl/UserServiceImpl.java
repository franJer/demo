package com.example.demo.service.impl;

import com.example.demo.model.dao.UserRepository;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public BigDecimal getTotalExpensesByUser(String userName) {
       User user = userRepository.findByName(userName);
       if (user != null) {
           BigDecimal totalExpenses = user.getExpenses()
                   .stream()
                   .map(e -> e.getExpenseValue() == null ? BigDecimal.ZERO : e.getExpenseValue() )
                   .reduce(BigDecimal.ZERO, BigDecimal::add);

           return totalExpenses;
       } else {
           return null;
       }

    }
}
