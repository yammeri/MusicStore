package org.example.entities;

import org.example.entities.enums.Category;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private Long providerId;
    private Category category;
    private String name;
    private Integer countInStock;
    private BigDecimal cost;

    public Product(Long id, Long providerId, Category category, String name, Integer countInStock, BigDecimal cost) {
        this.id = id;
        this.providerId = providerId;
        this.category = category;
        this.name = name;
        this.countInStock = countInStock;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(Integer countInStock) {
        this.countInStock = countInStock;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
