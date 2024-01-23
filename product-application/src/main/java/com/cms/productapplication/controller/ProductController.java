package com.cms.productapplication.controller;

import com.cms.productapplication.bean.Product;
import com.cms.productapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/createproduct", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getproduct/all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll() throws SQLException {
        List<Product> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/getproduct/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> get(@PathVariable(value = "id") Long id) {
        Product prod = productService.get(id);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @RequestMapping(value = "/getproductbyname/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> get(@PathVariable(value = "name") String name) {
        Product prod = productService.getByName(name);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @RequestMapping(value = "deletebyname/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> delete(@PathVariable(value = "name") String name) {
        productService.delete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
