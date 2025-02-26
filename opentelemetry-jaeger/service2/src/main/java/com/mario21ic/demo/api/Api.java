package com.mario21ic.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Api {
    public Api() {
    }

    @GetMapping("/product/1")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("15", HttpStatus.OK);
    }
}
