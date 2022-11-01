package com.crud.sena.controller;


import com.crud.sena.entity.Product;
import com.crud.sena.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products/new")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        try {
            return productService.getProduct(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product Not Found", ex);
        }
    }

    @PutMapping("/products/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/delete/{id}")
    public List<Product> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return productService.getProducts();
    }

}
