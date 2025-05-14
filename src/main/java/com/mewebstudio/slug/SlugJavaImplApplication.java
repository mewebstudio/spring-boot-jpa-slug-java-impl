package com.mewebstudio.slug;

import com.mewebstudio.slug.generator.SlugifySlugGenerator;
import com.mewebstudio.springboot.jpa.slug.EnableSlug;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSlug(generator = SlugifySlugGenerator.class)
public class SlugJavaImplApplication {
    public static void main(String[] args) {
        SpringApplication.run(SlugJavaImplApplication.class, args);
    }
}
