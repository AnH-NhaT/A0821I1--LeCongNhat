package com.anhnhat.jpa.productjpa.repository;

import com.anhnhat.jpa.productjpa.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
