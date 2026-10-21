package com.example.demotp2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "PRODUCT")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
