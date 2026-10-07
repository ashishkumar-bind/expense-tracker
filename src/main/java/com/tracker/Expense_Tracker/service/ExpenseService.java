package com.tracker.Expense_Tracker.service;

import com.tracker.Expense_Tracker.entity.Expense;
import com.tracker.Expense_Tracker.entity.User;
import com.tracker.Expense_Tracker.repository.ExpenseRepository;
import com.tracker.Expense_Tracker.repository.UserRepo;
import com.tracker.Expense_Tracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepo userRepo;

    public Expense saveExpense(Expense expense, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}