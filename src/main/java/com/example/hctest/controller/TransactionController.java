package com.example.hctest.controller;

import com.example.hctest.model.Code;
import com.example.hctest.dto.ContractDto;
import com.example.hctest.model.Status;
import com.example.hctest.model.Transaction;

import com.example.hctest.repository.CodesRepository;
import com.example.hctest.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private CodesRepository codesRepository;

    public TransactionController(){}
    public TransactionController(TransactionsRepository ts, CodesRepository cs) {
        this.transactionsRepository = ts;
        this.codesRepository = cs;
    }

    @PostMapping("/new")
    public void addContract(@RequestBody ContractDto incomeContract) {
        int code = incomeContract.getCode();
        int contactNumber = incomeContract.getContactNumber();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Status status = Status.valueOf(incomeContract.getStatus());
        Code dbCode = codesRepository.findByCode(code);
        if (dbCode == null) {
            Code newCode = new Code(code);
            codesRepository.saveAndFlush(newCode);
            transactionsRepository.save(new Transaction(codesRepository.findByCode(code).getId(), newCode, status, time, contactNumber));
        } else {
            transactionsRepository.save(new Transaction(dbCode.getId(), dbCode, status, time, contactNumber));
        }
    }


    @GetMapping("/alltransactions")
    public List<Transaction> getStatuses(){
        List<Transaction> allTransactions = this.transactionsRepository.findAll();
        return allTransactions;
    }

    @GetMapping("/statusbyid/{id}")
    public Transaction getStatusById(@PathVariable Long id){
        Transaction transaction = this.transactionsRepository.findById(id).get();
        return transaction;
    }

    @GetMapping("/statusbycode/{code}")
    public List<Status> getStatusByCode(@PathVariable int code){
        List<Transaction> transactions = this.transactionsRepository.findByCode(code);
        List<Status> statuses = new ArrayList<>();
        for(Transaction transaction : transactions){
            statuses.add(transaction.getStatus());
        }
        return statuses;
    }
}
