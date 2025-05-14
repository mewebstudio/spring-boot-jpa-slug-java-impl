package com.mewebstudio.slug.entity;

import com.mewebstudio.springboot.jpa.slug.ISlugSupport;
import com.mewebstudio.springboot.jpa.slug.SlugField;
import com.mewebstudio.springboot.jpa.slug.SlugListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
@EntityListeners(SlugListener.class)
public class Category extends AbstractBaseEntity implements ISlugSupport<String> {
    @SlugField
    private String name;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
