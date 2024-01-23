package com.cms.productapplication.service;

import com.cms.productapplication.bean.Product;
import com.cms.productapplication.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void save(Product product) {
        productRepo.save(product);
    }

    public List<Product> getAll() throws SQLException {
        return productRepo.findAll();

    }

    public Product get(Long id) {
        return productRepo.findById(id).get();
    }

    public Product getByName(String name) {
        return productRepo.findByName(name);
    }

    public void delete(String name) {
        productRepo.deleteByName(name);
    }


}
