package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.Fountain;
import com.rhodes.tapbackend.models.FountainReview;
import com.rhodes.tapbackend.models.Leaderboard;
import com.rhodes.tapbackend.repositories.FountainRepository;
import com.rhodes.tapbackend.repositories.FountainReviewRepository;
import com.rhodes.tapbackend.repositories.LeaderboardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class FountainService {

    @Autowired
    private FountainRepository fountainRepository;

    @Autowired
    private FountainReviewRepository fountainReviewRepository;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    // id and verified attributes set manually for new fountains
    public Fountain addFountain(float xCoord, float yCoord, String description, float rating, String author) {
        Optional<Leaderboard> exists = leaderboardRepository.findById(author);
        if (exists.isEmpty()) {
            leaderboardRepository.save(new Leaderboard(author, 100, 0));
        } else {
            Leaderboard row = exists.get();
            row.setPoints(row.getPoints() + 100);
            leaderboardRepository.save(row);
        }
        return fountainRepository.save(new Fountain(0, xCoord, yCoord, description, rating, false, author));
    }

    //credit to Darya for code structure from deleteAccount method
    public boolean deleteFountain(Integer fountainId) {
        Fountain fountain = fountainRepository.findById(fountainId)
                .orElse(null);
        if (fountain != null) {
            fountainRepository.delete(fountain);
            fountainReviewRepository.deleteAllById(Collections.singleton(fountainId));
            return true;
        } else {
            return false;
        }
    }

    public Optional<Fountain> findFountain(Integer fountainId) {
        return fountainRepository.findById(fountainId);
    }

    public void addFountainReview(Integer fountainId, String reviewer, String description, float rating) {
        Optional<Leaderboard> exists = leaderboardRepository.findById(reviewer);
        if (exists.isEmpty()) {
            leaderboardRepository.save(new Leaderboard(reviewer, 50, 0));
        } else {
            Leaderboard row = exists.get();
            row.setPoints(row.getPoints() + 50);
            leaderboardRepository.save(row);
        }
        fountainReviewRepository.save(new FountainReview(0, fountainId, reviewer, description, rating));
        //check if fountain can be verified
        if (fountainReviewRepository.getFountainReviewCount(fountainId) == 1) {
            Optional<Fountain> fountain = fountainRepository.findById(fountainId);
            fountain.get().setVerified(true);
        }
    }

    public Integer getFountainReviewCount(Integer fountainId) {
        return fountainReviewRepository.getFountainReviewCount(fountainId);
    }

    public void updateFountainRating(Integer fountainId, float oldRating, Fountain fountain) {
        Integer reviewCount = getFountainReviewCount(fountainId);
        float newFountainRating = (fountain.getRating() + oldRating) / (reviewCount + 1);
        fountain.setRating(newFountainRating);
    }

    public boolean userReviewExistsForFountain(Integer fountainId, String user) {
        Optional<Integer> exists = fountainReviewRepository.getExistingReview(fountainId, user);
        return exists.isPresent();
    }

    public List<Fountain> getFountainsInArea(float minLat, float minLon, float maxLat, float maxLon) {
        return fountainRepository.getFountainsInArea(minLat, minLon, maxLat, maxLon);
    }

    public List<Fountain> getFountainsByUser(String username) {
        return fountainRepository.getFountainsByUser(username);
    }
}
