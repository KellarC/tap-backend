package com.rhodes.tapbackend.repositories;

import com.rhodes.tapbackend.models.Fountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FountainRepository extends JpaRepository<Fountain, Integer> {

    @Query(value="SELECT * FROM fountains WHERE :minLat < y_coord AND :minLon < x_coord AND :maxLat > y_coord AND :maxLon > x_coord", nativeQuery = true)
    List<Fountain> getFountainsInArea(@Param("minLat") float minLat,
                                      @Param("minLon") float minLon,
                                      @Param("maxLat") float maxLat,
                                      @Param("maxLon") float maxLon);
}
