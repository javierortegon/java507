package com.crud.sena.controller;

import com.crud.sena.entity.Product;
import com.crud.sena.service.ProductService;
import com.crud.sena.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "product/all";
    }

    @GetMapping("/products/new")
    public String showNewProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("users", userService.getUsers());
        return "product/new";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("products/update/{id}")
    public String getUpdateProduct(@PathVariable long id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("users", userService.getUsers());
        return "product/update";
    }

    @PostMapping("products/update/{id}")
    public String updateProduct(@PathVariable long id, Product product){
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
