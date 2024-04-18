package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.ScoreboardDTO;
import com.rhodes.tapbackend.services.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scoreboard")
public class ScoreboardController {

    @Autowired
    private ScoreboardService scoreboardService;

    @PostMapping("/add-score")
    public ResponseEntity<?> addScore(@RequestBody ScoreboardDTO scoreboardDTO) {
        scoreboardService.addScore(scoreboardDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/get-top-scores")
    public ResponseEntity<List<ScoreboardDTO>> getTopScores(@RequestParam(defaultValue = "10") int limit) {
        List<ScoreboardDTO> topScores = scoreboardService.getTopScores(limit);
        return ResponseEntity.ok(topScores);
    }

    @GetMapping("/get-score/{playerName}")
    public ResponseEntity<ScoreboardDTO> getPlayerScore(@PathVariable String playerName) {
        ScoreboardDTO playerScore = scoreboardService.getPlayerScore(playerName);
        if (playerScore != null) {
            return ResponseEntity.ok(playerScore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
