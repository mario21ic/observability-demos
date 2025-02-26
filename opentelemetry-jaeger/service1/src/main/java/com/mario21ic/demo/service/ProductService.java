package com.mario21ic.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    RestTemplate restTemplate = new RestTemplate();

    public String getProductPrice() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://127.0.0.1:8081/product/1", String.class);
        return response.getBody();
    }
}
