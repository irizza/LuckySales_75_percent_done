package com.lyashuk.dao.impl;

import com.lyashuk.dao.api.ProductDao;
import com.lyashuk.db_util.DataSource;
import com.lyashuk.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 14.07.2016.
 */
public class ProductDaoImpl implements ProductDao {

    private static ProductDao productDao;
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String FIND_BY_ID = "select * from product where idProduct = ?";
    private static final String DELETE_PRODUCT_BY_ID = "delete  from product where idProduct = ?";
    private static final String CREATE_PRODUCT = "insert into product(idProduct, nameProduct, descriptionProduct, countProduct, priceProduct) VALUES (?,?,?,?,?)";

    private DataSource dataSource;

    private ProductDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    public static ProductDao getInstance() {
        if (productDao == null) {
            synchronized (ProductDaoImpl.class) {
                if (productDao == null) {
                    productDao = new ProductDaoImpl();
                }
            }
        }
        return productDao;
    }

    @Override
    public List<Product> findAll() {
        Connection connection = dataSource.getConnection();
        List<Product> products = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("idProduct"));
                product.setName(resultSet.getString("nameProduct"));
                product.setDescription(resultSet.getString("descriptionProduct"));
                product.setCount(resultSet.getInt("countProduct"));
                product.setPrice(resultSet.getDouble("priceProduct"));
                products.add(product);
            }
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public Product findById(long id) {
        Connection connection = dataSource.getConnection();
        Product product = new Product();

         try {
             PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
             ps.setLong(1,id);
             ResultSet resultSet = ps.executeQuery();
             while (resultSet.next()) {

                 product.setId(resultSet.getLong("idProduct"));
                 product.setName(resultSet.getString("nameProduct"));
                 product.setDescription(resultSet.getString("descriptionProduct"));
                 product.setCount(resultSet.getInt("countProduct"));
                 product.setPrice(resultSet.getDouble("priceProduct"));

             }

         }catch (SQLException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (connection != null) {
                     connection.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }

        return product;
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public boolean create(Product product) {
        Connection connection = dataSource.getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getCount());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.executeUpdate();

// execute insert SQL stetement



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
