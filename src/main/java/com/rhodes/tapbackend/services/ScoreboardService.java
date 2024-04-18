package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.exceptions.NotFoundException;
import com.rhodes.tapbackend.models.ScoreboardDTO;
import com.rhodes.tapbackend.repositories.ScoreboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    public List<ScoreboardDTO> getAllScores() {
        return scoreboardRepository.findAll();
    }

    public Optional<ScoreboardDTO> getScoreById(Long id) {
        return scoreboardRepository.findById(id);
    }

    public ScoreboardDTO addScore(ScoreboardDTO scoreboard) {
        return scoreboardRepository.save(scoreboard);
    }

    public void deleteScore(Long id) {
        scoreboardRepository.deleteById(id);
    }

    public List<ScoreboardDTO> getTopScores(int limit) {
        return scoreboardRepository.findTopScoresOrderByScoreDesc(limit);
    }

    public ScoreboardDTO getPlayerScore(String playerName) {
        return scoreboardRepository.findByPlayerName(playerName)
                .orElse(null);
    }

    public ScoreboardDTO updateScore(Long id, ScoreboardDTO newScoreboard) {
        Optional<ScoreboardDTO> optionalScoreboard = scoreboardRepository.findById(id);
        if (optionalScoreboard.isPresent()) {
            ScoreboardDTO existingScoreboard = optionalScoreboard.get();
            existingScoreboard.setPlayerName(newScoreboard.getPlayerName());
            existingScoreboard.setScore(newScoreboard.getScore());
            // Set other properties as needed
            return scoreboardRepository.save(existingScoreboard);
        } else {
            throw new NotFoundException("Scoreboard with ID " + id + " not found");
        }
    }
}
