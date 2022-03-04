package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Qualifier("productServiceImpl")
@Service
public class ProductServiceImpl implements IProductService{

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 11", 15000.0, 10, "vip"));
        products.put(2, new Product(2, "Iphone 11 Pro", 17000.0, 10, "vipPro"));
        products.put(3, new Product(3, "Iphone 12 Pro", 23000.0, 10, "So Wonderful"));
        products.put(4, new Product(4, "Iphone 13 Pro", 27000.0, 10, "Supper"));
        products.put(5, new Product(5, "Xiaomi Redmi Not 11", 7000.0, 10, "Cheap"));
        products.put(6, new Product(6, "Samsung Z Flip 3", 20000.0, 10, "vip"));
        products.put(7, new Product(7, "Samsung Z Fold 3", 30000.0, 10, "Of the president"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
