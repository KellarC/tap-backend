package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.ScoreboardDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreboardRepository extends JpaRepository<ScoreboardDTO, Long> {
}
