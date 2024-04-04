package com.rhodes.tapbackend.services; // Make sure to put in the correct package

import com.rhodes.tapbackend.models.ReviewDTO;
import com.rhodes.tapbackend.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void addReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setUserId(reviewDTO.getUserId());
        review.setContent(reviewDTO.getContent());
        // Set other properties of the review as needed

        reviewRepository.save(review);
    }

    public boolean likeReview(Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            review.setLikes(review.getLikes() + 1);
            reviewRepository.save(review);
            return true;
        }
        return false; // Review not found
    }

    public boolean commentOnReview(Long reviewId, String comment) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            review.getComments().add(comment);
            reviewRepository.save(review);
            return true;
        }
        return false; // Review not found
    }

    // Other methods of ReviewService...
}