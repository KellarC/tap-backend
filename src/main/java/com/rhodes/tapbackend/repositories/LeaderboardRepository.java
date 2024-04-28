package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, String> {

    @Query(value="SELECT * FROM leaderboard ORDER BY points DESC", nativeQuery = true)
    List<Leaderboard> getLeaderboardDescending();
}