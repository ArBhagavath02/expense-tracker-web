package com.expensetracker.repository;

import com.expensetracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCategory(String category);
    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);
}