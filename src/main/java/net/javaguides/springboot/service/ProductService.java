package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.ProductRequest;
import net.javaguides.springboot.dto.ProductResponse;
import net.javaguides.springboot.mapper.ProductMapper;
import net.javaguides.springboot.repository.ProductRepository;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AuthService authService;

    public void save(ProductRequest productRequest) {
        productRepository.save(ProductMapper.mapProduct(productRequest, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map(productMapper::mapToDto).collect(toList());
    }

}
