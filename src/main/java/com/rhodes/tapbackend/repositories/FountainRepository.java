package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Fountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FountainRepository extends JpaRepository<Fountain, Integer> {

}