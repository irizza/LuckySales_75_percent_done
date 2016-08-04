package com.lyashuk.dao.impl;

import com.lyashuk.dao.api.ProductGroupDao;
import com.lyashuk.db_util.DataSource;
import com.lyashuk.entity.ProductGroup;

import java.util.List;

/**
 * Created by User on 14.07.2016.
 */
public class ProductGroupDaoImpl implements ProductGroupDao {

    private static ProductGroupDao productGroupDao;
    private static final String SELECT_ALL_PRODUCTS = "select * from user";
    private static final String FIND_BY_ID = "select * from user where id = ?";
    private static final String DELETE_PRODUCT_BY_ID = "delete * from user where id = ?";
   /* private static final String CREATE_PRODUCT = "insert into user(?,?,?)";*/

    private DataSource dataSource;

    private ProductGroupDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    public static ProductGroupDao getInstance() {
        if (productGroupDao == null) {
            synchronized (ProductGroupDaoImpl.class) {
                if (productGroupDao == null) {
                    productGroupDao = new ProductGroupDaoImpl();
                }
            }
        }
        return productGroupDao;
    }


    @Override
    public List<ProductGroup> findAll() {
        return null;
    }

    @Override
    public ProductGroup findById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean create(ProductGroup productGroup) {
        return false;
    }


}
