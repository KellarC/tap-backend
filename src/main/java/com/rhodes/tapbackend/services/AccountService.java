package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.entities.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccounts();             //GET ALL
    Optional<Account> getAccountById(Long id);  //GET

    //Optional<Account> signIn(String username, String plaintext_password);


    Account postAccount(Account account);       //POST


    //Account signUp(Account account);


    Account updateAccount(Account account);     //PUT
    void deleteAccount(Long id);                //DELETE


}