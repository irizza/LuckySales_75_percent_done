package com.lyashuk.db_util;

import com.lyashuk.Listener;
import com.lyashuk.holders.PropertyHolders;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Kovantonlenko on 12/10/2015.
 */
public class DataSource {


private static PropertyHolders propertyHolders = PropertyHolders.getInstanceDC();
    private static DataSource dataSource;
    private static Properties property = Listener.getProperties();



    private DataSource() {
    }

    public static DataSource getInstance() {

        if (dataSource == null) {
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }

    public Connection getConnection() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        Connection conn = null;
        try {

            cpds.setDriverClass(propertyHolders.getDriverClass()); //loads the jdbc driver
            cpds.setJdbcUrl(propertyHolders.getJdbcUrl());
            cpds.setUser(propertyHolders.getUser());
            cpds.setPassword(propertyHolders.getPassword());

            cpds.setMinPoolSize(propertyHolders.getMinPoolSize());
            cpds.setAcquireIncrement(propertyHolders.getAcquireIncrement());
            cpds.setMaxPoolSize(propertyHolders.getMaxPoolSize());

            conn = cpds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
