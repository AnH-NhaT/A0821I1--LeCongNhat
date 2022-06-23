package com.anhnhat.jpa.productjpa.service;

import com.anhnhat.jpa.productjpa.model.Product;
import com.anhnhat.jpa.productjpa.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(Long[] id) {
        Arrays.stream(id).forEach(e -> productRepo.deleteById(e));
    }

    @Override
    public Page<Product> searchAllFields(String keywords, Pageable pageable) {
        return productRepo.searchAllFields(keywords, pageable);
    }

    @Override
    public Page<Product> searchByName(String keywords, Pageable pageable) {
        return productRepo.getAllByNameContaining(keywords, pageable);
    }

    @Override
    public Page<Product> searchByPrice(String keywords, Pageable pageable) {
        return productRepo.searchAllByPrice(keywords, pageable);
    }

    @Override
    public Page<Product> searchByCategory(String keywords, Pageable pageable) {
        return productRepo.searchByCategory(keywords, pageable);
    }

    @Override
    public Page<Product> sortInAscName(Pageable pageable) {
        return productRepo.sortInAscName(pageable);
    }

    @Override
    public Page<Product> sortInDescName(Pageable pageable) {
        return productRepo.sortInDescName(pageable);
    }

    @Override
    public Page<Product> sortInAscPrice(Pageable pageable) {
        return productRepo.sortInAscPrice(pageable);
    }

    @Override
    public Page<Product> sortInDescPrice(Pageable pageable) {
        return productRepo.sortInDescPrice(pageable);
    }

    @Override
    public Page<Product> sortInAscExpiration(Pageable pageable) {
        return productRepo.sortInAscExpiration(pageable);
    }

    @Override
    public Page<Product> sortInDescExpiration(Pageable pageable) {
        return productRepo.sortInDescExpiration(pageable);
    }


}
