package com.mewebstudio.slug.dto.request;

public class UpdateProductRequest {
    private String categoryId;

    private String title;

    public UpdateProductRequest() {
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
