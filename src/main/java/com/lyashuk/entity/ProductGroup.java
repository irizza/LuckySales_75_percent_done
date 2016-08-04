package com.lyashuk.entity;

import java.util.ArrayList;
import java.util.List;


public class ProductGroup {
    private Long id;
    private String description;
    List<Product> products = new ArrayList<Product>();

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
