package com.ymsli.bank.transaction;

import com.ymsli.bank.transaction.dto.DepositRequest;
import com.ymsli.bank.transaction.dto.WithdrawRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Deposit money into an account.
     * Only CLERK is allowed.
     */
    @PreAuthorize("hasRole('CLERK')")
    @PostMapping("/deposit")
    public String deposit(@RequestBody DepositRequest request) {

        transactionService.deposit(
                request.getAccountNumber(),
                request.getAmount(),
                request.getClerkId()
        );

        return "Deposit completed successfully";
    }

    /**
     * Withdraw money from an account.
     * Only CLERK is allowed.
     * High-value withdrawals go for manager approval.
     */
    @PreAuthorize("hasRole('CLERK')")
    @PostMapping("/withdraw")
    public String withdraw(@RequestBody WithdrawRequest request) {

        transactionService.withdraw(
                request.getAccountNumber(),
                request.getAmount(),
                request.getClerkId()
        );

        return "Withdrawal request submitted";
    }
}
