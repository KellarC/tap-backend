package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.ScoreboardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ScoreboardRepository extends JpaRepository<ScoreboardDTO, Long> {
    List<ScoreboardDTO> findTopScoresOrderByScoreDesc(int limit);

    Optional<ScoreboardDTO> findByPlayerName(String playerName);
}

