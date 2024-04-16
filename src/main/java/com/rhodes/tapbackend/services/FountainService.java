package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.Fountain;
import com.rhodes.tapbackend.models.FountainReview;
import com.rhodes.tapbackend.repositories.FountainRepository;
import com.rhodes.tapbackend.repositories.FountainReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FountainService {

    @Autowired
    private FountainRepository fountainRepository;

    @Autowired
    private FountainReviewRepository fountainReviewRepository;

    // id and verified attributes set manually for new fountains
    public Fountain addFountain(float xCoord, float yCoord, String description, float rating, String author) {
        return fountainRepository.save(new Fountain(0, xCoord, yCoord, description, rating, false, author));
    }

    //credit to Darya for code structure from deleteAccount method
    public boolean deleteFountain(Integer fountainId) {
        Fountain fountain = fountainRepository.findById(fountainId)
                .orElse(null);
        if (fountain != null) {
            fountainRepository.delete(fountain);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Fountain> findFountain(Integer fountainId) {
        return fountainRepository.findById(fountainId);
    }

    public void addFountainReview(Integer fountainId, String reviewer, String description, float rating) {
        fountainReviewRepository.save(new FountainReview(0, fountainId, reviewer, description, rating));
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
}
