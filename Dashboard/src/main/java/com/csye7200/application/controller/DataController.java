package com.csye7200.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/v1")
public class DataController {

    @GetMapping(value = "/getSongCount",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSongCount( ){

        try{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( e.getMessage());
        }

    }
}
