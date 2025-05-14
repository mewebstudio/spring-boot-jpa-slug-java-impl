package com.mewebstudio.slug.dto.response;

import com.mewebstudio.slug.entity.Category;

import java.time.LocalDateTime;

public class CategoryResponse extends AbstractBaseResponse {
    private String id;

    private String name;

    private String slug;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public CategoryResponse(String id, String name, String slug, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static CategoryResponse convert(Category category) {
        CategoryResponse parentResponse = null;

        return new CategoryResponse(
            category.getId(),
            category.getName(),
            category.getSlug(),
            category.getCreatedAt(),
            category.getUpdatedAt()
        );
    }
}
