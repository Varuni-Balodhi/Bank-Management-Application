package com.ymsli.bank.audit;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymsli.bank.transaction.Transaction;
import com.ymsli.bank.transaction.TransactionRepository;

@Service
@Transactional(readOnly = true)
public class AuditService {

    private final TransactionRepository transactionRepository;

    public AuditService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Page<Transaction> getAllTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    public Page<Transaction> getTransactionsByAccountNumber(
            String accountNumber, Pageable pageable) {
        return transactionRepository.findByAccount_AccountNumber(accountNumber, pageable);
    }

    public List<Transaction> getPendingApprovals() {
        return transactionRepository.findPendingApprovalsWithDetails();
    }
}
