package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.entities.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long id);
    Account postAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(Long id);
}