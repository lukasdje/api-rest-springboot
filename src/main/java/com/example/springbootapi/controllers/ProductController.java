package com.example.springbootapi.controllers;

import com.example.springbootapi.DTO.ProductRecordDTO;
import com.example.springbootapi.models.ProductModel;
import com.example.springbootapi.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDTO productRecordDTO){
        var productsModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDTO, productsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productsModel));
    }
}
