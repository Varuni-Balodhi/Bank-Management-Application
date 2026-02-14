package com.ymsli.bank.account;

import com.ymsli.bank.account.dto.AccountResponse;
import com.ymsli.bank.account.dto.CreateAccountRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Create a new bank account.
     * Accessible only by MANAGER.
     */
    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping
    public AccountResponse createAccount(
            @RequestBody CreateAccountRequest request) {

        Account account = accountService.createAccount(request.getHolderName());

        return new AccountResponse(
                account.getAccountNumber(),
                account.getHolderName(),
                account.getBalance(),
                account.getCreatedAt()
        );
    }
}
