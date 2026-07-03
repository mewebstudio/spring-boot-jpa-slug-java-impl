package com.mewebstudio.slug.service;

import com.mewebstudio.slug.dto.request.CreateProductRequest;
import com.mewebstudio.slug.dto.request.UpdateProductRequest;
import com.mewebstudio.slug.entity.Product;
import com.mewebstudio.slug.exception.NotFoundException;
import com.mewebstudio.slug.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(
            () -> new NotFoundException("Product not found with id: " + id)
        );
    }

    public Product create(CreateProductRequest request) {
        Product product = new Product();
        product.setCategory(categoryService.findById(request.getCategoryId()));
        product.setTitle(request.getTitle());

        return productRepository.save(product);
    }

    public Product update(String id, UpdateProductRequest request) {
        Product product = findById(id);

        if (request.getCategoryId() != null) {
            product.setCategory(categoryService.findById(request.getCategoryId()));
        }
        if (request.getTitle() != null) {
            product.setTitle(request.getTitle());
        }

        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.delete(findById(id));
    }
}
