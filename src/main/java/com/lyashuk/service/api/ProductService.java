package com.lyashuk.service.api;

import com.lyashuk.dto.ProductDto;

import java.util.List;


/**
 * Created by root on 16.06.2016.
 */
public interface ProductService {
    ProductDto getProductById(Long id);
    void createProduct(ProductDto productDto);
    boolean deleteProduct(long id);
    List<ProductDto> getAllProducts();
}
