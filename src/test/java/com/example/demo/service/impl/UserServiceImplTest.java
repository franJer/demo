package com.example.demo.service.impl;

import com.example.demo.model.dao.UserRepository;
import com.example.demo.model.entity.Expense;
import com.example.demo.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    private static String NAME = "name";

    @Mock
    UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void FindTotalByUserName() {

        Expense expense1 = Expense.builder().expenseValue(new BigDecimal("10")).build();
        Expense expense2 = Expense.builder().expenseValue(new BigDecimal("30")).build();
        ArrayList listOfExpenses = new ArrayList();
        listOfExpenses.add(expense1);
        listOfExpenses.add(expense2);

        User user1 = User.builder().name(NAME).expenses(listOfExpenses).build();

        Mockito.when(userRepository.findByName(Mockito.anyString())).thenReturn(user1);

        BigDecimal totalExpenses = userService.getTotalExpensesByUser(NAME);

        assertEquals(new BigDecimal("40"), totalExpenses);

    }
}