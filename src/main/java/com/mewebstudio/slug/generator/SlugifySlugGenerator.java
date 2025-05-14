package com.mewebstudio.slug.generator;

import com.github.slugify.Slugify;
import com.mewebstudio.springboot.jpa.slug.ISlugGenerator;
import com.mewebstudio.springboot.jpa.slug.SlugOperationException;

public class SlugifySlugGenerator implements ISlugGenerator {
    private final Slugify slugify;

    public SlugifySlugGenerator() {
        this.slugify = Slugify.builder().lowerCase(true).build();
    }

    @Override
    public String generate(String input) {
        try {
            if (input == null || input.isBlank()) {
                throw new SlugOperationException("Input cannot be null or blank: " + input);
            }
            String slug = slugify.slugify(input);
            if (slug.length() > 255) {
                slug = slug.substring(0, 255);
            }
            return slug;
        } catch (Exception e) {
            throw new SlugOperationException("Slug generation failed: " + e.getMessage(), e);
        }
    }
}
