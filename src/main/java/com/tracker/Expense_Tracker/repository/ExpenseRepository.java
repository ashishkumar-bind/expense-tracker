package com.tracker.Expense_Tracker.repository;

import com.tracker.Expense_Tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
