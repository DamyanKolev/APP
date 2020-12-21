package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.ProductService;
import net.javaguides.springboot.dto.ProductRequest;
import net.javaguides.springboot.dto.ProductResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/")
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequest productRequest){
        productService.save(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }
}
