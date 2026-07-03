package com.mewebstudio.slug.entity;

import com.mewebstudio.springboot.jpa.slug.ISlugSupport;
import com.mewebstudio.springboot.jpa.slug.SlugField;
import com.mewebstudio.springboot.jpa.slug.SlugListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
@EntityListeners(SlugListener.class)
@SlugField(fields = {"category.name", "title"})
public class Product extends AbstractBaseEntity implements ISlugSupport<String> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    @Override
    public void setSlug(String slug) {
        this.slug = slug;
    }
}
