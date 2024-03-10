package com.rhodes.tapbackend.services;

import com.rhodes.tapbackend.models.Fountain;
import com.rhodes.tapbackend.repositories.FountainRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FountainService {

    @Autowired
    private FountainRepository fountainRepository;

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
}
