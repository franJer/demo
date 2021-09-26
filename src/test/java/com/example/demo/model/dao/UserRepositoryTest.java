package com.example.demo.model.dao;

import com.example.demo.model.entity.Expense;
import com.example.demo.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    private static String NAME = "name";

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        Expense expense1 = Expense.builder().expenseValue(new BigDecimal("10")).build();
        Expense expense2 = Expense.builder().expenseValue(new BigDecimal("30")).build();
        ArrayList listOfExpenses = new ArrayList();
        listOfExpenses.add(expense1);
        listOfExpenses.add(expense2);

        User user1 = User.builder().name(NAME).expenses(listOfExpenses).build();
        User userInserted = userRepository.save(user1);

        assertNotNull(userInserted.getId());
        assertEquals(userInserted.getName(), NAME);
        assertEquals(userInserted.getExpenses().size(), 2);
    }


}