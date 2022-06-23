package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    int save(Product e);

    int delete(int id);

    List<Product> search(String name);
}
