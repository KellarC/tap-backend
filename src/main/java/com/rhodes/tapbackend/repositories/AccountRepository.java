package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // For use with signIn method
    //@Query("SELECT Account.password FROM Account WHERE username = Account.username")
    //String getPasswordViaUsername(String username);
}
