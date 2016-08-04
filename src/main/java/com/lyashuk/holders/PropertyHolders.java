package com.lyashuk.holders;

import com.lyashuk.Listener;
import java.util.Properties;


public class PropertyHolders {
    private String user;
    private String password;
    private String dbHost;
    private String dbName;
    private String jdbcUrl;
    private String dbUser;
    private String dbPassword;
    private String minPoolSize;
    private String acquireIncrement;
    private String maxPoolSize;
    private String driverClass;
    private static volatile PropertyHolders _instance = null;
    private Properties property = new Properties();

    private PropertyHolders() {
        try {
            property = Listener.getProperties();


            if (property.size() > 0) {
                driverClass = property.getProperty("luckySale.driverClass");
                jdbcUrl = property.getProperty("luckySale.JdbcUrl");
                user = property.getProperty("luckySale.user");
                password = property.getProperty("luckySale.dbPassword");
               /* dbHost = property.getProperty("luckySale.dbHost");*/
                dbName = property.getProperty("luckySale.dbName");
//                dbUser = property.getProperty("luckySale.dbUser");
//                dbPassword = property.getProperty("luckySale.dbPassword");
                minPoolSize = property.getProperty("luckySale.minPoolSize");
                acquireIncrement = property.getProperty("luckySale.acquireIncrement");
                maxPoolSize = property.getProperty("luckySale.maxPoolSize");

            } else {
                System.err.println("Erorr: empty file");
            }}catch(Exception e){
                System.err.println("Erorr : 404 File Not Found");
            }
    }


        public static synchronized PropertyHolders getInstanceDC(){
            if(_instance == null) {
                synchronized (PropertyHolders.class) {
                    if (_instance == null) {
                        _instance = new PropertyHolders();
                    }
                }
            }
            return _instance;
        }


public Integer getMinPoolSize() {
    return Integer.parseInt(minPoolSize);
}

    public Integer getAcquireIncrement() {
        return Integer.parseInt( acquireIncrement);
    }

    public Integer getMaxPoolSize() {
        return Integer.parseInt( maxPoolSize);
    }
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDriverClass() {
        return driverClass;
    }



}
