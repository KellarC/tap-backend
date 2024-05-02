package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {
    Optional<ApplicationUser> findByUsername(String username);

    @Query(value="SELECT username, first_name, last_name, email FROM users WHERE username = :username", nativeQuery = true)
    List<String> getUserDetailsByUsername(@Param("username") String username);
}
