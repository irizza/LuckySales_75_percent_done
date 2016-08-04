package com.lyashuk.service.impl;

import com.lyashuk.entity.Product;
import com.lyashuk.helper.Transformer;
import com.lyashuk.service.api.ProductService;
import com.lyashuk.dto.ProductDto;
import com.lyashuk.dao.impl.ProductDaoImpl;
import com.lyashuk.dao.api.ProductDao;

import java.util.List;


public class ProductServiceImpl implements ProductService {

    private static ProductService productService;
    private ProductDao productDao;

    private ProductServiceImpl() {
        productDao = ProductDaoImpl.getInstance();
    }

    public static ProductService getInstance() {
        if (productService == null) {
            synchronized (ProductServiceImpl.class) {
                if (productService == null) {
                    productService = new ProductServiceImpl();
                }
            }
        }
        return productService;
    }

    public ProductDto getProductById(Long id) {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        return productDto;
    }
    

    public void createProduct(ProductDto productDto){
        Product product = Transformer.transformProductDTOToProduct(productDto);
        productDao.create(product);
    }

    public boolean deleteProduct(long id) {
        productDao.delete(id);
        return true;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productDao.findAll();
        List<ProductDto> productDtos = Transformer.transformLisProductsToProductDto(products);
        return productDtos;
    }


}
