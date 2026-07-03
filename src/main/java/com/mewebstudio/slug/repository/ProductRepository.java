package com.mewebstudio.slug.repository;

import com.mewebstudio.slug.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
