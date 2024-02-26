package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.models.Fountain;
import com.rhodes.tapbackend.models.FountainDTO;
import com.rhodes.tapbackend.services.FountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fountain")
@CrossOrigin("*")
public class FountainController {

    @Autowired
    private FountainService fountainService;

    @PostMapping("/add")
    public Fountain addFountain(@RequestBody FountainDTO body) {
        return fountainService.addFountain(body.getxCoord(),
                body.getyCoord(),
                body.getDescription(),
                body.getAuthor());
    }
}
