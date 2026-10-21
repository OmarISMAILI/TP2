package com.example.demotp2;

import com.example.demotp2.entities.Product;
import com.example.demotp2.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoTp2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoTp2Application.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            Product p1 = Product.builder()
                    .name("Dell Laptop")
                    .price(3900)
                    .quantity(1)
                    .build();
            Product p2 = Product.builder()
                    .name("Asus Laptop")
                    .price(20000)
                    .quantity(1)
                    .build();
            productRepository.save(p1);
            productRepository.save(p2);

            List<Product> product = productRepository.findAll();
            product.forEach(p->{
                System.out.println(p.toString());
                    });
        };
    }
}