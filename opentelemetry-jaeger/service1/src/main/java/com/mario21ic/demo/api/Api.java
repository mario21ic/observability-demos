package com.mario21ic.demo.api;

import com.mario21ic.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Api {
    ProductService productService;

    public Api(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        String precio = productService.getProductPrice();
        return new ResponseEntity<>("El precio del producto 1 es " + precio, HttpStatus.OK);
//        return new ResponseEntity<>("Holi boli", HttpStatus.OK);
    }
}
