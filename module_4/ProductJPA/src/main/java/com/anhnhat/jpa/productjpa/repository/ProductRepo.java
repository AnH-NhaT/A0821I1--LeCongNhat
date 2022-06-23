package com.anhnhat.jpa.productjpa.repository;

import com.anhnhat.jpa.productjpa.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);

    Page<Product> getAllByNameContaining(String keywords, Pageable pageable);

    @Query(value = "SELECT * FROM product WHERE price LIKE %:keywords%", nativeQuery = true)
    Page<Product> searchAllByPrice(String keywords, Pageable pageable);

    @Query(value = "SELECT * FROM product WHERE price LIKE %:keywords% OR name LIKE %:keywords% OR expiration LIKE %:keywords%", nativeQuery = true)
    Page<Product> searchAllFields(String keywords, Pageable pageable);

    @Query(value = "SELECT * FROM product WHERE category_id = :keywords", nativeQuery = true)
    Page<Product> searchByCategory(String keywords, Pageable pageable);

    @Query(value = "SELECT * FROM product ORDER BY name ASC", nativeQuery = true)
    Page<Product> sortInAscName(Pageable pageable);

    @Query(value = "SELECT * FROM product ORDER BY name DESC", nativeQuery = true)
    Page<Product> sortInDescName(Pageable pageable);

    @Query(value = "SELECT * FROM product ORDER BY price ASC", nativeQuery = true)
    Page<Product> sortInAscPrice(Pageable pageable);

    @Query(value = "SELECT * FROM product ORDER BY price DESC", nativeQuery = true)
    Page<Product> sortInDescPrice(Pageable pageable);

    @Query(value = "SELECT * FROM product ORDER BY expiration ASC", nativeQuery = true)
    Page<Product> sortInAscExpiration(Pageable pageable);

    @Query(value = "SELECT * FROM product ORDER BY expiration DESC", nativeQuery = true)
    Page<Product> sortInDescExpiration(Pageable pageable);
}
