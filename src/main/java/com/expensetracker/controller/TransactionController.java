package com.expensetracker.controller;

import com.expensetracker.model.Transaction;
import com.expensetracker.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction transaction) {
        transaction.setId(id);
        return repository.save(transaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}