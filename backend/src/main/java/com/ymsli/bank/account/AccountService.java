package com.ymsli.bank.account;

import com.ymsli.bank.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Creates a new bank account.
     * Only MANAGER can trigger this via controller.
     */
    public Account createAccount(String holderName) {

        String accountNumber = generateAccountNumber();

        Account account = new Account(accountNumber, holderName);
        return accountRepository.save(account);
    }

    /**
     * Fetch account using account number.
     */
    public Account getByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                                "Account not found: " + accountNumber
                        )
                );
    }

    /**
     * Credit amount to account.
     * Used for deposits.
     */
    public void credit(Account account, BigDecimal amount) {
        account.credit(amount);
        accountRepository.save(account);
    }

    /**
     * Debit amount from account.
     * Used only after validation/approval.
     */
    public void debit(Account account, BigDecimal amount) {
        account.debit(amount);
        accountRepository.save(account);
    }

    /**
     * Generates unique account number.
     */
    private String generateAccountNumber() {
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
