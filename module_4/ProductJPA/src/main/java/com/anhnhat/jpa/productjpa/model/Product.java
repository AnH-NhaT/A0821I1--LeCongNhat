package com.anhnhat.jpa.productjpa.model;

import com.anhnhat.jpa.productjpa.validation.DateValid;
import com.anhnhat.jpa.productjpa.validation.NumberValid;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NumberValid(message = "Price must be a number and from 0 to 999999")
    private double price;
    @DateValid(message = "Expiration date is at least 3 months from now")
    private LocalDate expiration;
    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
