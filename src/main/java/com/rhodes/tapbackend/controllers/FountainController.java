package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.*;
import com.rhodes.tapbackend.services.FountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/fountain")
@CrossOrigin("*")
public class FountainController {

    @Autowired
    private FountainService fountainService;

    @PostMapping("/add")
    public Fountain addFountain(@RequestBody FountainDTO fountainDTO) {
        return fountainService.addFountain(fountainDTO.getxCoord(),
                fountainDTO.getyCoord(),
                fountainDTO.getDescription(),
                fountainDTO.getRating(),
                fountainDTO.getAuthor());
    }

    //credit to Darya for code structure from deleteAccount endpoint
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFountain(@RequestBody DeleteFountainDTO deleteFountainDTO) {
        boolean deleted = fountainService.deleteFountain(deleteFountainDTO.getFountainId());
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/add-review")
    public ResponseEntity<?> addFountainReview(@RequestBody FountainReviewDTO fountainReviewDTO) {
        Optional<Fountain> fountain = fountainService.findFountain(fountainReviewDTO.getFountainId());
        if (fountain.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            boolean exists = fountainService.userReviewExistsForFountain(fountainReviewDTO.getFountainId(), fountainReviewDTO.getReviewer());
            if (exists) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                fountainService.addFountainReview(fountainReviewDTO.getFountainId(),
                        fountainReviewDTO.getReviewer(),
                        fountainReviewDTO.getDescription(),
                        fountainReviewDTO.getRating());
                fountainService.updateFountainRating(fountainReviewDTO.getFountainId(), fountainReviewDTO.getRating(), fountain.get());
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
    }

    @GetMapping("/get-in-area")
    public List<Fountain> getFountainsInArea(@RequestBody FountainsInAreaDTO fountainsInAreaDTO) {
        return fountainService.getFountainsInArea(
                fountainsInAreaDTO.getMinLat(),
                fountainsInAreaDTO.getMinLon(),
                fountainsInAreaDTO.getMaxLat(),
                fountainsInAreaDTO.getMaxLon());
    }
}
