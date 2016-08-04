package com.lyashuk.dao.api;


import com.lyashuk.entity.ProductGroup;

import java.util.List;

public interface ProductGroupDao {
    List<ProductGroup> findAll();

    ProductGroup findById(long id);

    void delete(long id);

    boolean create(ProductGroup productGroup);
}
