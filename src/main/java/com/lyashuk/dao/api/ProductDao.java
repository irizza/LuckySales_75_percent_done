package com.lyashuk.dao.api;

import com.lyashuk.entity.Product;


import java.util.List;

/**
 * Created by User on 14.07.2016.y7
 */
 public interface ProductDao {
    List<Product> findAll();

    Product findById(long id);

    void delete(long id);

    boolean create(Product product);
}
