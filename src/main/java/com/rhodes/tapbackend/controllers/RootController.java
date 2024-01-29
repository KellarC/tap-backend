package com.rhodes.tapbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/root")
    public String index() {
        return "Hello from Tap!\n";
    }
}
