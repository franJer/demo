package com.example.demo.model.dao;

import com.example.demo.model.entity.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    Expense findById(long id);
}
