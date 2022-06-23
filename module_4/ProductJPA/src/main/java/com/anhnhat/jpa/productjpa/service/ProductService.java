package com.anhnhat.jpa.productjpa.service;

import com.anhnhat.jpa.productjpa.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    void deleteById(Long[] id);

    Page<Product> searchByName(String keywords, Pageable pageable);

    Page<Product> searchByPrice(String keywords, Pageable pageable);

    Page<Product> searchAllFields(String keywords, Pageable pageable);

    Page<Product> searchByCategory(String keywords, Pageable pageable);

    Page<Product> sortInAscName(Pageable pageable);

    Page<Product> sortInDescName(Pageable pageable);

    Page<Product> sortInAscPrice(Pageable pageable);

    Page<Product> sortInDescPrice(Pageable pageable);

    Page<Product> sortInAscExpiration(Pageable pageable);

    Page<Product> sortInDescExpiration(Pageable pageable);
}
