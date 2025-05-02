package com.meac.authentication_api.controller;

import com.meac.authentication_api.domain.product.Product;
import com.meac.authentication_api.domain.product.ProductRequestDTO;
import com.meac.authentication_api.domain.product.ProductResponseDTO;
import com.meac.authentication_api.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {


    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }






    @PostMapping
    public ResponseEntity<Void> postProduct(@RequestBody @Valid ProductRequestDTO productRequest) {

        Product product = new Product();
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productList = productRepository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productList);
    }




}
