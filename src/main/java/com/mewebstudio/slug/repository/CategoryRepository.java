package com.mewebstudio.slug.repository;

import com.mewebstudio.slug.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
