package com.tracker.Expense_Tracker.controller;

import com.tracker.Expense_Tracker.dto.ExpenseRequest;
import com.tracker.Expense_Tracker.entity.Expense;
import com.tracker.Expense_Tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // 1. Create
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDate(request.getDate());

        Expense saved = expenseService.saveExpense(expense, request.getUserId());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 2. Read All
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    // 3. Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        if (expense.isPresent()) {
            return new ResponseEntity<>(expense.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 4. Update
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,
                                                 @RequestBody Expense expenseDetails) {
        Optional<Expense> optionalExpense = expenseService.getExpenseById(id);

        if (optionalExpense.isPresent()) {
            Expense existing = optionalExpense.get();
            existing.setTitle(expenseDetails.getTitle());
            existing.setAmount(expenseDetails.getAmount());
            existing.setCategory(expenseDetails.getCategory());
            existing.setDate(expenseDetails.getDate());

            Expense updated = expenseService.saveExpense(existing);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        Optional<Expense> optionalExpense = expenseService.getExpenseById(id);

        if (optionalExpense.isPresent()) {
            expenseService.deleteExpense(id);
            return new ResponseEntity<>("Expense Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Expense Not Found", HttpStatus.NOT_FOUND);
        }
    }
}