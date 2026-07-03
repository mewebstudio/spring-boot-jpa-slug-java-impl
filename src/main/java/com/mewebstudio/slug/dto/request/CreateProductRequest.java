package com.mewebstudio.slug.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CreateProductRequest {
    @NotBlank(message = "Category ID cannot be blank")
    private String categoryId;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    public CreateProductRequest() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
