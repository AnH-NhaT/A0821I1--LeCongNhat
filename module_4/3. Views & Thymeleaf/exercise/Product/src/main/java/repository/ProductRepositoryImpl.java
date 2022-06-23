package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepo {
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "nhat", 2000, "none", "micro"));
        productList.add(new Product(2, "nhi", 3000, "none", "sun"));
        productList.add(new Product(3, "tam", 1000, "none", "rice"));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public int save(Product product) {
        boolean rs = productList.add(product);
        if (rs) return 1;
        else return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Product> search(String name) {
        return null;
    }
}
