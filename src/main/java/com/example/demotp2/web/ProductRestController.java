package com.example.demotp2.web;

import com.example.demotp2.entities.Product;
import com.example.demotp2.repository.ProductRepository;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> allProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found"));
    }

    @GetMapping("/find/products")
    public List<Product> findProducts(
            @RequestParam(name="kw", defaultValue = "")
            String kw){
        return productRepository.findByNameContainsIgnoreCase(kw);
    }


    @PostMapping("/products")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id){
        productRepository.deleteById(id);
    }


    @PostMapping("/products/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        Product existingProduct = productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found"));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }
}
