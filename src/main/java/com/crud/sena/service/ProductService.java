package com.crud.sena.service;

import com.crud.sena.entity.Product;
import com.crud.sena.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository iProductRepository;

    public List<Product> getProducts(){
        return iProductRepository.findAll();
    }

    public Product saveProduct(Product product){
        return iProductRepository.save(product);
    }

    public Product getProduct(Long id){
        return iProductRepository.findById(id).get();
    }

    public Product updateProduct(Product product){
        return iProductRepository.save(product);
    }

    public void deleteProduct(Long id){
        iProductRepository.deleteById(id);
    }

}
