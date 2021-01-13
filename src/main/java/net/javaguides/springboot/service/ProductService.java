package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.request.ProductRequest;
import net.javaguides.springboot.dto.response.ProductResponse;
import net.javaguides.springboot.mapper.ProductMapper;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductRepository;
import net.javaguides.springboot.repository.UserRepository;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AuthService authService;
    private final UserRepository userRepository;

    public void create(ProductRequest productRequest) {
        userRepository.findByUsername("Kolev").get().addProduct(productMapper.mapProduct(productRequest));
        // authService.getCurrentUser().get().addProduct(productMapper.mapProduct(productRequest));
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map(productMapper::mapToDto).collect(toList());
    }

    public void update(ProductRequest productRequest) {
        // update product information
        Product product = productMapper.mapProduct(productRequest);
        product.setId(productRequest.getProductId());
        // save change into database
        productRepository.save(product);

    }

    public void delete(Long id) {
        // delete product information
        productRepository.deleteById(id);
    }

    public ResponseEntity<List<ProductResponse>> findPage(final int pageNumber,final int pageSize) {
        //Set the page size
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        //search items for the page
        Page<Product> page = productRepository.findAll(pageable);
        //get all items and save into list
        List<ProductResponse> products = productMapper.mapToListDto(page.getContent());

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
