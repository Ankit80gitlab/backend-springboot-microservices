package com.cms.productapplication.repo;

import com.cms.productapplication.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
    Product findByName(String name);

    void deleteByName(String name);

}
