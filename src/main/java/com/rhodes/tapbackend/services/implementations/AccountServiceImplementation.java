package com.rhodes.tapbackend.services.implementations;

import com.rhodes.tapbackend.entities.Account;
import com.rhodes.tapbackend.repositories.AccountRepository;
import com.rhodes.tapbackend.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() { return accountRepository.findAll(); }

    @Override
    public Optional<Account> getAccountById(Long account_id) { return accountRepository.findById(account_id); }

    public Account postAccount(Account account) { return accountRepository.save(account); }

    public Account updateAccount(Account account) { return accountRepository.save(account); }

    public void deleteAccount(Long account_id) { accountRepository.deleteById(account_id);}
}