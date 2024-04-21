package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.FountainReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FountainReviewRepository extends JpaRepository<FountainReview, Integer> {
    @Query(value="SELECT COUNT(fountain_id) FROM reviews WHERE fountain_id = :fountainId", nativeQuery = true)
    Integer getFountainReviewCount(@Param("fountainId") Integer fountainId);

    @Query(value="SELECT review_id FROM reviews WHERE fountain_id = :fountainId AND reviewer = :user", nativeQuery = true)
    Optional<Integer> getExistingReview(@Param("fountainId") Integer fountainId, @Param("user") String user);
}
