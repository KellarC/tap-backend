package com.rhodes.tapbackend.services.implementations;

import com.rhodes.tapbackend.entities.Account;
import com.rhodes.tapbackend.repositories.AccountRepository;
import com.rhodes.tapbackend.services.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /* signIn(username, password)
    1. get encoded password from account table via username
    2. encode plaintext password
    3. do the passwords match?
        if so, return _ ?
        if not, deny login ?
     */

    /*@Override
    public Optional<Account> signIn(String username, String plaintext_password) {
        String encoded_password = accountRepository.getPasswordViaUsername(username); // step 1
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        String matcher = bCryptPasswordEncoder.encode(plaintext_password); // step 2
        if (Objects.equals(encoded_password, matcher)) { // step 3
            return Optional.empty();
        }
        return Optional.empty();
    }*/
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Account postAccount(Account account) { return accountRepository.save(account); }

    /*public Account signUp(Account account) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        String encoded_password = bCryptPasswordEncoder.encode(account.getPassword()); // encode the user's password
        account.setPassword(encoded_password); // replace plaintext password with encoded password
        return accountRepository.save(account); // put account information in Account table
    }*/

    public Account updateAccount(Account account) { return accountRepository.save(account); }

    public void deleteAccount(Long account_id) { accountRepository.deleteById(account_id);}
}