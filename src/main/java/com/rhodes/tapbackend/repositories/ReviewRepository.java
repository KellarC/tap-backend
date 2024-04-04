package com.rhodes.tapbackend.repositories;

import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}