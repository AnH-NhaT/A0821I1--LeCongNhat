package service;

import model.Product;
import repository.ProductRepo;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo = new ProductRepositoryImpl();

    @Override
    public List<Product> getAll() {
        return productRepo.getAll();
    }

    @Override
    public int save(Product e) {
        return productRepo.save(e);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Product> search(String name) {
        return productRepo.search(name);
    }
}
