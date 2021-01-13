package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.ProductService;
import net.javaguides.springboot.dto.request.ProductRequest;
import net.javaguides.springboot.dto.response.ProductResponse;
import net.javaguides.springboot.model.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequest productRequest) {
        productService.create(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestBody ProductRequest productRequest) {
        productService.update(productRequest);
        return new ResponseEntity<>("Your Product Updated Successful", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") final Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list-products")
    public ResponseEntity<List<ProductResponse>> findPaginated() {

        return productService.findPage(1, 4);
    }
}
