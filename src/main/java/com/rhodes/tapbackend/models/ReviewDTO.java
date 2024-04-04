import com.rhodes.tapbackend.repositories.ReviewRepository;


public class ReviewDTO {
    private ReviewRepository reviewRepository;
    private Long userId;
    private String content;
    // Add other necessary fields for a review

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

}
