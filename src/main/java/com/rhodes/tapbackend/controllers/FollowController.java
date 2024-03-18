package com.rhodes.tapbackend.controllers;

import com.rhodes.tapbackend.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
@CrossOrigin("*")
public class FollowController {

    @Autowired
    private FollowService followService;


}
