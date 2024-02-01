package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.entities.Account;
import com.rhodes.tapbackend.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {this.accountService = accountService; }

    @GetMapping
    public List<Account> getAllAccounts() {return accountService.getAllAccounts(); }

    @GetMapping("/{account_id}")
    public Optional<Account> getAccountById(@PathVariable("account_id") Long account_id) { return accountService.getAccountById(account_id); }

    /*@GetMapping("/{username}&{password}")
    public Optional<Account> signIn(@PathVariable("username") String username, @PathVariable("password") String plaintext_password) { return AccountService.signIn(username, plaintext_password); }*/

    @PostMapping
    public Account postAccount(@RequestBody Account account) { return accountService.postAccount(account); }

    /*@PostMapping
    public Account signUp(@RequestBody Account account) { return accountService.signUp(account); }*/

    @PutMapping
    public Account updateAccount(@RequestBody Account account) { return accountService.updateAccount(account); }

    @DeleteMapping("/{account_id}")
    public void deleteAccount(@PathVariable("account_id") Long account_id) { accountService.deleteAccount(account_id); }
}