package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.DeleteFountainDTO;
import com.rhodes.tapbackend.models.Fountain;
import com.rhodes.tapbackend.models.FountainDTO;
import com.rhodes.tapbackend.services.FountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fountain")
@CrossOrigin("*")
public class FountainController {

    @Autowired
    private FountainService fountainService;

    @PostMapping("/add")
    public Fountain addFountain(@RequestBody FountainDTO fountainDTO) {
        return fountainService.addFountain(fountainDTO.getxCoord(),
                fountainDTO.getyCoord(),
                fountainDTO.getDescription(),
                fountainDTO.getRating(),
                fountainDTO.getAuthor());
    }

    //credit to Darya for code structure from deleteAccount endpoint
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFountain(@RequestBody DeleteFountainDTO deleteFountainDTO) {
        boolean deleted = fountainService.deleteFountain(deleteFountainDTO.getFountainId());
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
