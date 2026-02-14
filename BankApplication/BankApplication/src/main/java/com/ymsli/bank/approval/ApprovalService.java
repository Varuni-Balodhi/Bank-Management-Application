package com.ymsli.bank.approval;

import org.springframework.stereotype.Service;

import com.ymsli.bank.account.Account;
import com.ymsli.bank.account.AccountService;
import com.ymsli.bank.exception.ResourceNotFoundException;
import com.ymsli.bank.transaction.Transaction;
import com.ymsli.bank.transaction.TransactionRepository;
import com.ymsli.bank.transaction.TransactionStatus;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApprovalService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public ApprovalService(TransactionRepository transactionRepository,
                           AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    public void approve(Long transactionId, Long managerId) {

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Transaction not found: " + transactionId
                        )
                );

        if (transaction.getStatus() != TransactionStatus.PENDING_APPROVAL) {
            throw new IllegalStateException(
                    "Transaction is not pending approval"
            );
        }

        // Deduct balance only after approval
        Account account = transaction.getAccount();
        accountService.debit(account, transaction.getAmount());

        // Controlled state transition
        transaction.markApproved(managerId);

        transactionRepository.save(transaction);
    }

    public void reject(Long transactionId, Long managerId) {

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Transaction not found: " + transactionId
                        )
                );

        if (transaction.getStatus() != TransactionStatus.PENDING_APPROVAL) {
            throw new IllegalStateException(
                    "Transaction is not pending approval"
            );
        }

        // Controlled state transition
        transaction.markRejected(managerId);

        transactionRepository.save(transaction);
    }
}
