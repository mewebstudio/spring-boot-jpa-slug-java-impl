package com.mewebstudio.slug.dto.response;

import com.mewebstudio.slug.entity.Product;

import java.time.LocalDateTime;

public class ProductResponse extends AbstractBaseResponse {
    private String id;

    private String categoryId;

    private String categoryName;

    private String title;

    private String slug;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ProductResponse(
        String id,
        String categoryId,
        String categoryName,
        String title,
        String slug,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.title = title;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ProductResponse convert(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getCategory().getId(),
            product.getCategory().getName(),
            product.getTitle(),
            product.getSlug(),
            product.getCreatedAt(),
            product.getUpdatedAt()
        );
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
