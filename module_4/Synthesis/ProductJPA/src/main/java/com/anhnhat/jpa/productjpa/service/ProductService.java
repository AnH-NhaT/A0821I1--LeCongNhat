package com.anhnhat.jpa.productjpa.service;

import com.anhnhat.jpa.productjpa.model.Product;
import com.anhnhat.jpa.productjpa.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    public void save(Product product) {
        productRepo.save(product);
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    public Page<Product> search(String name, String price, String expiration, String category_id, Pageable pageable) {
        return productRepo.search(name, price, expiration, category_id, pageable);
    }

}
