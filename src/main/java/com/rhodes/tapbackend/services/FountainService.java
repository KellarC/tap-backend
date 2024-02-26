package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.Fountain;
import com.rhodes.tapbackend.repositories.FountainRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FountainService {

    @Autowired
    private FountainRespository fountainRespository;

    public Fountain addFountain(float xCoord, float yCoord, String description, String author) {
        return fountainRespository.save(new Fountain(0, xCoord, yCoord, description, 0, false, author));
    }


}
