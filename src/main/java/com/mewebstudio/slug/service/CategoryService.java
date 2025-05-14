package com.mewebstudio.slug.service;

import com.mewebstudio.slug.dto.request.CreateCategoryRequest;
import com.mewebstudio.slug.dto.request.UpdateCategoryRequest;
import com.mewebstudio.slug.entity.Category;
import com.mewebstudio.slug.exception.NotFoundException;
import com.mewebstudio.slug.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(String id) {
        return categoryRepository.findById(id).orElseThrow(
            () -> new NotFoundException("Category not found with id: " + id)
        );
    }

    public Category create(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();
        category.setName(createCategoryRequest.getName());

        return categoryRepository.save(category);
    }

    public Category update(String id, UpdateCategoryRequest request) {
        Category category = findById(id);
        if (request.getName() != null) {
            category.setName(request.getName());
        }

        return categoryRepository.save(category);
    }

    public void delete(String id) {
        categoryRepository.delete(findById(id));
    }
}
