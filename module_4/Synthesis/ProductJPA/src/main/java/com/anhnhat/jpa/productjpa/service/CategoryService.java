package com.anhnhat.jpa.productjpa.service;

import com.anhnhat.jpa.productjpa.model.Category;
import com.anhnhat.jpa.productjpa.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll() {
        if (categoryRepo.findAll().isEmpty()) {
            categoryRepo.save(new Category("TV"));
            categoryRepo.save(new Category("Phone"));
            categoryRepo.save(new Category("Laptop"));
        }
        return categoryRepo.findAll();
    }
}
