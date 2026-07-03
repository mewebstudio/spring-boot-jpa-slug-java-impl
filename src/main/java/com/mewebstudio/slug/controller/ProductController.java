package com.mewebstudio.slug.controller;

import com.mewebstudio.slug.dto.request.CreateProductRequest;
import com.mewebstudio.slug.dto.request.UpdateProductRequest;
import com.mewebstudio.slug.dto.response.ProductResponse;
import com.mewebstudio.slug.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> list() {
        return ResponseEntity.ok(productService.findAll().stream().map(ProductResponse::convert).toList());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        return new ResponseEntity<>(ProductResponse.convert(productService.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> show(@PathVariable String id) {
        return ResponseEntity.ok(ProductResponse.convert(productService.findById(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
        @PathVariable String id,
        @Valid @RequestBody UpdateProductRequest request
    ) {
        return ResponseEntity.ok(ProductResponse.convert(productService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
