package com.anhnhat.jpa.productjpa.repository;

import com.anhnhat.jpa.productjpa.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product WHERE name LIKE %:name% AND price LIKE %:price% AND expiration LIKE %:expiration% AND category_id LIKE %:category_id%", nativeQuery = true)
    Page<Product> search(String name, String price, String expiration,String category_id, Pageable pageable);

}
