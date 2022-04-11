package com.controller;

import com.entity.*;
import com.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class SampleController {

    @Autowired
    private SampleService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/data")
    public InitializeData getRandomCard(){
        return service.getInitializeData();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/rounddata")
    public RoundResultData getRoundResult(@RequestBody RequestResultData request){
        return service.getRoundResult(request);
    }

}
